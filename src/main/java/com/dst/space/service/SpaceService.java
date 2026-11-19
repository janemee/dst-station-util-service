package com.dst.space.service;

import cn.hutool.core.collection.CollectionUtil;
import com.dst.space.bean.SpaceSyncParam;
import com.dst.space.bean.WorkOrderQuery;
import com.dst.station.bean.SubUpdateDstBpmInstDataParams;
import com.dst.station.bean.TechnicalModificationWorkOrderVO;
import com.dst.station.common.HttpUtils;
import com.dst.station.common.SBYWorkOrderConst;
import com.dst.station.common.SpaceSign;
import com.dst.station.common.SpaceSignUtil;
import com.dst.station.service.SbyService;
import com.dst.steed.common.domain.response.PageDTO;
import com.dst.steed.common.domain.response.Response;
import com.dst.steed.common.util.DstJsonUtil;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Headers;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
public class SpaceService {
    //    @Value("${space.application.appId}")
    public static String appId = "pWMLZhljTOYH4la8";

    //    @Value("${space.application.appSecret}")
    public static String appSecret = "c19sqXByD2iCzZJiFZhGpo4HPqyiIQT";

    //    @Value("${space.application.tenementCode.dst}")
    public static String tenementCode = "DST001";

//    @Value("${space.workorder.projectCode}")
    public static String projectCode = "DST001_XM_00000002";

    //    @Value("${space.workorder.appId}")
    public static String woAppId ="G001";

    public static void main(String[] args) {
        //更新工单运营人员
        test();
//        String content = "FWYJGD741781617019246";
//        String[] orderCodes = content.split("\n");
//        for (String orderCode : orderCodes) {
//            Map<String, Object> updateWorkOrderDataMap = new HashMap<>();
//            updateWorkOrderDataMap.put("workOrderStatus", "40");
////            updateWorkOrderDataMap.put("ywgdmc", "维保预约单");
////            updateWorkOrderDataMap.put("txbq", System.currentTimeMillis());
//            SbyService.updateWorkOrderTableData("pre", "ifb39dacf9ffa40f7944de06d42284b89", orderCode, updateWorkOrderDataMap);
//        }
//        String content = "WBYYD0371776040265102\n" +
//                "WBYYD0371775864016793";
//        System.out.println(DstJsonUtil.toString(content.split("\n")) );

    }

    public static void test() {

        String host = "http://portal-gw-space.dev.dstcar.com/psp-mdc-gw-app/api-bpm";
        String api = "/extApi/bpmInstDataDst/updateDstBpmInstData";

        SubUpdateDstBpmInstDataParams subUpdateDstBpmInstDataParams = new SubUpdateDstBpmInstDataParams();
        subUpdateDstBpmInstDataParams.setAlias("m_djclzb_m");
        subUpdateDstBpmInstDataParams.setDataId("2100911742255620098");
        subUpdateDstBpmInstDataParams.setOrderCode("CLZJ00381789959527073");

        SpaceSign sign = signStr(subUpdateDstBpmInstDataParams);
        Headers headers = new Headers.Builder()
                .add("op-app-id", appId)
                .add("op-app-sign", sign.getSignStr())
                .add("op-app-time", sign.getTime())
                .add("projectCode", projectCode)
                .add("appId", woAppId)
                .build();
      String response = HttpUtils.doPost(host + api, headers, subUpdateDstBpmInstDataParams);
        System.out.println(response);
    }
    public static SpaceSign signStr(Object object) {
        SpaceSign sign = SpaceSignUtil.getSignStr(appId, appSecret,
                object instanceof String ? (String) object : DstJsonUtil.toString(object));
        return sign;
    }
    public Response syncSpace(SpaceSyncParam param) {
        if (CollectionUtil.isNotEmpty(param.getOrderCodes())){
            return syncTechnicalModificationWorkOrder(param);
        }
        log.info("【空间同步】开始同步数据,param:{}", DstJsonUtil.toString(param));
        List<String> successOrderCodes = new ArrayList<>();
        List<String> errorOrderCodes = new ArrayList<>();
        //字段
//        String fields = "ywgdmc,faultTypeArr,faultTypeValues";
        int pageNum = 1;
        WorkOrderQuery query = new WorkOrderQuery();
        query.setPageSize(100);
        query.setFormAlias(SBYWorkOrderConst.MAINTENANCE_RESERVATION_WORK_ORDER_FORM_TYPE);
        query.setFormAlias("m_workorder_1754901127067_m");
        do {
            query.setPageNo(pageNum);
            PageDTO pageDTO = SbyService.querySpaceFormListName(param.getEnv(), param.getToken(), query);
            if (pageDTO == null || CollectionUtil.isEmpty(pageDTO.getList())) {
                break;
            }
            List<Map<String, Object>> workOrderList = DstJsonUtil.toObject(pageDTO.getList(), List.class);
            //查询技改工单信息
            if (CollectionUtil.isNotEmpty(workOrderList)) {
                //检测必填字段是否为空
                for (Map<String, Object> workOrderMap : workOrderList) {
                    Map<String, Object> updateWorkOrderDataMap = new HashMap<>();
                    updateWorkOrderDataMap.put("ywgdmc", "维保预约单");
                    Object faultTypeArr = workOrderMap.get("F_FAULTTYPEARR_LABELS");
                    if (faultTypeArr == null) {
                        updateWorkOrderDataMap.put("faultTypeArr", "{\"label\":\"1\",\"value\":\"1\"}");
                    }
                    // 所属客户id 为空更新
                    if (workOrderMap.get("customerId")==  null){
                        updateWorkOrderDataMap.put("customerId", "1");
                    }
                    String orderCode = (String) workOrderMap.get("orderCode");
                    //表单更新
                    SbyService.updateWorkOrderTableData(param.getEnv(), param.getToken(), orderCode, updateWorkOrderDataMap);
                    //同步工单数据到派单中心
                    Response response = SbyService.syncWorkOrder(param.getEnv(), param.getToken(), orderCode, param.getDispatchOrderTypeCode());
                    if (response.isSuccess()) {
                        successOrderCodes.add(orderCode);
                    } else {
                        errorOrderCodes.add(orderCode);
                    }
                }
            }
            if (pageDTO.getTotalPage() == pageNum) {
                log.info("【空间同步】结束同步数据,pageNum:{}", pageNum);
                break;
            }
            log.info("【空间同步】开始同步数据,pageNum:{}", pageNum);
            pageNum++;
        } while (true);

        log.info("【空间同步】结束同步数据");
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("successOrderCodes", successOrderCodes);
        resultMap.put("total", successOrderCodes.size() + errorOrderCodes.size());
        resultMap.put("success", successOrderCodes.size());
        resultMap.put("error", errorOrderCodes.size());
        resultMap.put("errorOrderCodes", errorOrderCodes);
        return Response.succeed(resultMap);
    }

    /**
     * 根据工单编号查询工单信息
     *
     * @param param
     * @return
     */
    public Response syncTechnicalModificationWorkOrder(SpaceSyncParam param) {
        List<String> successOrderCodes = new ArrayList<>();
        List<String> errorOrderCodes = new ArrayList<>();

        WorkOrderQuery query = new WorkOrderQuery();
        query.setFormAlias("m_workorder_1754901127067_m");

        for (String orderCode : param.getOrderCodes()) {
            query.addParams("orderCode", orderCode);
            PageDTO pageDTO = SbyService.querySpaceFormListName(param.getEnv(), param.getToken(), query);
            List<Map<String, Object>> workOrderList = DstJsonUtil.toObject(pageDTO.getList(), List.class);
            //查询技改工单信息
            if (CollectionUtil.isNotEmpty(workOrderList)) {
                //检测必填字段是否为空
                for (Map<String, Object> workOrderMap : workOrderList) {
                    Map<String, Object> updateWorkOrderDataMap = new HashMap<>();
                    updateWorkOrderDataMap.put("ywgdmc", "维保预约单");
                    Object faultTypeArr = workOrderMap.get("F_FAULTTYPEARR_LABELS");
                    if (faultTypeArr == null) {
                        updateWorkOrderDataMap.put("faultTypeArr", "{\"label\":\"1\",\"value\":\"1\"}");
                    }
                    // 所属客户id 为空更新
                    if (workOrderMap.get("customerId")==  null){
                        updateWorkOrderDataMap.put("customerId", "1");
                    }
                    //表单更新
                    SbyService.updateWorkOrderTableData(param.getEnv(), param.getToken(), orderCode, updateWorkOrderDataMap);
                    //同步工单数据到派单中心
                    Response response = SbyService.syncWorkOrder(param.getEnv(), param.getToken(), orderCode, param.getDispatchOrderTypeCode());
                    if (response.isSuccess()) {
                        successOrderCodes.add(orderCode);
                    } else {
                        errorOrderCodes.add(orderCode);
                    }
                }
            }
        }

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("successOrderCodes", successOrderCodes);
        resultMap.put("total", successOrderCodes.size() + errorOrderCodes.size());
        resultMap.put("success", successOrderCodes.size());
        resultMap.put("error", errorOrderCodes.size());
        resultMap.put("errorOrderCodes", errorOrderCodes);
        return Response.succeed(resultMap);
    }


}
