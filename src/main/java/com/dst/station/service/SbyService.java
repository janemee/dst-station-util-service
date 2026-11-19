package com.dst.station.service;


import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.json.JSONObject;
import com.dst.space.bean.WorkOrderQuery;
import com.dst.station.bean.*;
import com.dst.station.common.CommonUtil;
import com.dst.station.common.QualityChecklistConst;
import com.dst.station.common.SBYWorkOrderConst;
import com.dst.station.common.VehicleAttrConst;
import com.dst.station.common.HttpUtils;
import com.dst.steed.common.domain.response.PageDTO;
import com.dst.steed.common.domain.response.Response;
import com.dst.steed.common.util.DstJsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.*;

@Slf4j
@Service
public class SbyService {

    /**
     * 根据工单编号查询工单表单数据
     *
     * @param env
     * @param token
     * @param orderCode
     * @param tableDataMap
     * @return
     */
    public static Object updateWorkOrderTableData(String env, String token, String orderCode, Map<String, Object> tableDataMap) {
        Map<String, Object> params = new HashMap<>();
        //工单编号
        params.put("orderCode", orderCode);
        // 更新字段
        params.put("tableData", tableDataMap);
        String result = HttpUtils.doPost(getInstance(env, CommonUtil.updateWorkOrderTableData), token, params);
        Response<List<JSONObject>> response = DstJsonUtil.toObject(result, Response.class);
        return response.getData();
    }


    public static PageDTO querySpaceFormListName(String env, String token, WorkOrderQuery param) {

        String result = HttpUtils.doPost(getInstance(env, CommonUtil.getFormObjectDataListByPage), token, param);
        Response<Object> response = DstJsonUtil.toObject(result, Response.class);
        PageDTO pageDTO = DstJsonUtil.toObject(response.getData(), PageDTO.class);
        return pageDTO;
    }


    public static TechnicalModificationWorkOrderVO getTechnicalTransformationOrder(String env, String token, String orderCode) {
        Map<String, String> params = new HashMap<>();
        //工单编号
        params.put("Q_ORDER_CODE_S_IN", orderCode);
        // 交车工单表名
        params.put("formListName", SBYWorkOrderConst.TECHNICAL_MODIFICATION_WORK_ORDER_FORM_TYPE);
        String result = HttpUtils.doPost(getInstance(env, CommonUtil.URL), token, params);
        Response<List<JSONObject>> response = DstJsonUtil.toObject(result, Response.class);
        if (response != null && CollectionUtil.isNotEmpty(response.getData())) {
            return DstJsonUtil.toObject(response.getData().get(0), TechnicalModificationWorkOrderVO.class);
        }
        return null;
    }


    /**
     * 获取技改工单-技改验收表单信息
     *
     * @param orderCode
     * @return
     */
    public static TechnicalModificationWorkOrderSubVO getTechnicalTransformationOrderSub(String env, String token, String orderCode) {

        List<TaskButtonFormVo> taskButtonFormVos = getTaskButtonsFormData(env, token, orderCode);
        if (null != taskButtonFormVos) {
            // 查到第一个“登记车辆质检”的关联表单
            for (TaskButtonFormVo taskButtonFormVo : taskButtonFormVos) {
                if ("jgjgdjbd".equals(taskButtonFormVo.getAlias())) {
                    return DstJsonUtil.toObject(taskButtonFormVo.getData(), TechnicalModificationWorkOrderSubVO.class);
                }
            }
        }
        return null;
    }


    /**
     * 查询思倍云关联表单
     */
    public static List<TaskButtonFormVo> getTaskButtonsFormData(String env, String token, String orderCode) {
        TaskButtonFormParam param = new TaskButtonFormParam();
        param.setOrderCode(orderCode);
        log.info("查询质检工单关联表单,【{}】", DstJsonUtil.toString(param));
        String res = HttpUtils.doPost(getInstance(env, CommonUtil.SUB_URL), token, param);
        Response<TaskButtonFormVo> response = DstJsonUtil.toObject(res, Response.class);
        log.info("查询质检工单关联表单结果,【{}】", DstJsonUtil.toString(response));
        if (response.isSuccess()) {
            return DstJsonUtil.toList(response.getData(), TaskButtonFormVo.class);
        } else {
            log.error("查询质检工单关联表单错误: {}", response.getMsg());
            return new ArrayList<>();
        }
    }

    public static Response<?> batchRemoveTailBoard(BatchSaveTailBoardParam tailBoardParam, String token, String env) {
        String url = "/dst-apis/1/vehicleCenter/openapi/tailBoard/batchRemove";
        String result = HttpUtils.doPost(getInstance(env, url), token, tailBoardParam);
        return DstJsonUtil.toObject(result, Response.class);
    }

    public static Response<?> batchSaveTailBoard(BatchSaveTailBoardParam tailBoardParam, String token, String env) {
        String url = "/dst-apis/1/vehicleCenter/openapi/tailBoard/batchSave";
        String result = HttpUtils.doPost(getInstance(env, url), token, tailBoardParam);
        return DstJsonUtil.toObject(result, Response.class);
    }

    /**
     * 查询车辆信息，
     *
     * @param vinCode
     * @return
     */
    public static VehicleVO queryVehicleInfo(String env, String token, String vinCode) {
        if (StringUtils.isBlank(vinCode)) {
            return null;
        }
        VehicleQuery query = new VehicleQuery();
        query.setVinCode(vinCode);
        query.setAttrKeys(Arrays.asList(VehicleAttrConst.A_CAR_OPT_COMPANY, VehicleAttrConst.VEHICLE_REGISTRATION_YEAR_ATTR_KEY, QualityChecklistConst.A_OPT_ASSET_CLASSIFY,
                VehicleAttrConst.AK_G_CAR_BRAND, VehicleAttrConst.AK_G_CAR_MODEL));
        String url = "/dst-apis/1/vehicleCenter/out/newVehicleCenterApi/queryVehicleInfo";

        String result = HttpUtils.doPost(getInstance(env, url), token, query);
        Response<?> response = DstJsonUtil.toObject(result, Response.class);
        VehicleVO vehicleVO = DstJsonUtil.toObject(response.getData(), VehicleVO.class);
        if (Objects.isNull(vehicleVO)) {
            return null;
        }
        VehicleOperatingVO vehicleOperating = vehicleVO.getVehicleOperating();
        if (Objects.isNull(vehicleOperating)) {
            return null;
        }

        return vehicleVO;
    }


    public static Response<?> updateVehicleAttrByMq(String env, String token, CarAttrChangeMessage message) {
        String url = "/dst-apis/1/vehicleCenter/out/newVehicleCenterApi/updateVehicleAttrByMq";
        String result = HttpUtils.doPost(getInstance(env, url), token, message);
        return DstJsonUtil.toObject(result, Response.class);
    }

    /**
     * 获取请求全路径
     *
     * @param env 环境
     * @param url 请求路径
     * @return 请求全路径
     */
    public static String getInstance(String env, String url) {
        String url_header = "http://portal-admin.dev.dstcar.com";
        if ("pre".equals(env)) {
            url_header = "http://portal-admin.pre.dstcar.com";
        } else if ("test".equals(env)) {
            url_header = "http://portal-admin.test.dstcar.com";
        } else if ("prod".equals(env)) {
            url_header = "https://eportal-admin.dstcar.com";
        } else if ("uat".equals(env)) {
            url_header = "http://portal-admin.uat.dstcar.com";
        }
        return String.format("%s%s", url_header, url);
    }

    /**
     * 获取请求全路径
     *
     * @param env 环境
     * @param url 请求路径
     * @return 请求全路径
     */
    public static String getInstanceCar(String env, String url) {
        String url_header = "https://portal-car-center.dev.dstcar.com";
        if ("pre".equals(env)) {
            url_header = "https://portal-car-center.pre.dstcar.com";
        } else if ("test".equals(env)) {
            url_header = "https://portal-car-center.test.dstcar.com";
        } else if ("prod".equals(env)) {
            url_header = "https://portal-car-center.dstcar.com";
        } else if ("uat".equals(env)) {
            url_header = "https://portal-car-center.uat.dstcar.com";
        }
        return String.format("%s%s", url_header, url);
    }

    /**
     * 同步工单数据到派单中心
     *
     * @param env
     * @param token
     * @param orderCode
     * @param dispatchOrderTypeCode
     * @return
     */
    public static Response syncWorkOrder(String env, String token, String orderCode, String dispatchOrderTypeCode) {
        Map<String, Object> params = new HashMap<>();
        //工单编号
        params.put("orderCode", orderCode);
        //工单类型编码
        params.put("dispatchOrderTypeCode", dispatchOrderTypeCode);
        String result = HttpUtils.doPost(getInstance(env, CommonUtil.syncWorkOrderDataToDispatch), token, params);
        Response<Object> response = DstJsonUtil.toObject(result, Response.class);
        return response;

    }

    /**
     * 同步工单数据到派单中心
     *
     * @param env
     * @param token
     * @param params
     * @return
     */
    public static Response transferWorkOrder(String env, String token, Object params) {
        String result = HttpUtils.doPost(getInstance(env, CommonUtil.transferWorkOrder), token, params);
        Response<Object> response = DstJsonUtil.toObject(result, Response.class);
        return response;
    }

    /**
     * 更新派单中心数据
     *
     * @param env
     * @param token
     * @param params
     * @return
     */
    public static Response sync(String env, String token, Object params) {
        String result = HttpUtils.doPost(getInstance(env, CommonUtil.transferWorkOrder), token, params);
        Response<Object> response = DstJsonUtil.toObject(result, Response.class);
        return response;
    }

    public static Response syncWorkOrderAfterCreate(String env, String token, Object params) {
        String result = HttpUtils.doPost(getInstance(env, CommonUtil.syncWorkOrderAfterCreate), token, params);
        Response<Object> response = DstJsonUtil.toObject(result, Response.class);
        return response;
    }

    public static Response syncWorkOrderUpdateData(String env, String token, Object params) {
        String result = HttpUtils.doPost(getInstance(env, CommonUtil.syncWorkOrderUpdateData), token, params);
        Response<Object> response = DstJsonUtil.toObject(result, Response.class);
        return response;
    }

    public static Response manualExecuteDispatchStrategy(String env, String token, Object params) {
        String result = HttpUtils.doPost(getInstance(env, CommonUtil.manualExecuteDispatchStrategy), token, params);
        Response<Object> response = DstJsonUtil.toObject(result, Response.class);
        return response;
    }

    public static Response<PageDTO<DataPoolDataDO>> queryDataPoolDataByPage(String env, String token, Object params) {
        String result = HttpUtils.doPost(getInstance(env, CommonUtil.queryDataPoolDataByPage), token, params);
        Response response = DstJsonUtil.toObject(result, Response.class);

        String data = DstJsonUtil.toString(response.getData());
        PageDTO<DataPoolDataDO> pageDTO = DstJsonUtil.toObject(data, PageDTO.class);
        response.setData(pageDTO);
        return response;
    }

    public static Response<PageDTO<DispatchErrorRecord>> queryDataPoolDataByError(String env, String token, Object params) {
        String result = HttpUtils.doPost(getInstance(env, CommonUtil.queryDataPoolDataByError), token, params);
        Response response = DstJsonUtil.toObject(result, Response.class);

        String data = DstJsonUtil.toString(response.getData());
        PageDTO<DispatchErrorRecord> pageDTO = DstJsonUtil.toObject(data, PageDTO.class);
        response.setData(pageDTO);
        return response;
    }





    public static Response queryWorkOrderDispatchUser(String env, String token, Object params) {
        String result = HttpUtils.doPost(getInstance(env, CommonUtil.queryWorkOrderDispatchUser), token, params);
        Response<Object> response = DstJsonUtil.toObject(result, Response.class);
        return response;
    }

    public static Response technicalTransformationUpdateCarAttribute(String env, String token, String orderCode) {
        Map<String, Object> params = new HashMap<>();
        params.put("orderCode", orderCode);
        params.put("busCode", "LYJG20250429");
        String result = HttpUtils.doPost(getInstance(env, CommonUtil.technicalTransformationUpdateCarAttribute), token, params);
        Response<Object> response = DstJsonUtil.toObject(result, Response.class);
        return response;
    }
    public static Response updateTailBoard(String env, String token, String orderCode) {
        Map<String, Object> params = new HashMap<>();
        params.put("orderCode", orderCode);
        params.put("busCode", "LYJG20250429");
        String result = HttpUtils.doPost(getInstance(env, CommonUtil.updateTailBoard), token, params);
        Response<Object> response = DstJsonUtil.toObject(result, Response.class);
        return response;
    }
    public static Response submitIotDeviceCode(String env, String token, String orderCode) {
        Map<String, Object> params = new HashMap<>();
        params.put("orderCode", orderCode);
        params.put("busCode", "LYJG20250429");
        String result = HttpUtils.doPost(getInstance(env, CommonUtil.submitIotDeviceCode), token, params);
        Response<Object> response = DstJsonUtil.toObject(result, Response.class);
        return response;
    }

    public static Response createQualityWorkOrders(String env, String token, Object params  ) {
        String result = HttpUtils.doPost(getInstance(env, CommonUtil.createQualityWorkOrders), token, params);
        Response<Object> response = DstJsonUtil.toObject(result, Response.class);
        return response;
    }


    public static Response<WorkOrderDetailDTO> queryWorkOrderDetailByOrderCode(String env, String token, String orderCode) {
        String url = CommonUtil.queryWorkOrderDetailByOrderCode.replace("{orderCode}", orderCode);
        String result = HttpUtils.doGet(getInstance(env, url), token);
        Response<WorkOrderDetailDTO> response = DstJsonUtil.toObject(result, Response.class);
        return response;
    }

    public static Response<Object>  notifyAfterCompletion(String env, String token, Object params) {
        String result = HttpUtils.doPost(getInstance(env, CommonUtil.notifyAfterRepairVerification), token, params);
        Response<Object> response = DstJsonUtil.toObject(result, Response.class);
        return response;
    }

    public static Response<Object>  queryInventoryCarMaintenanceTaskStatus(String env, String token, Object params) {
        String result = HttpUtils.doPost(getInstanceCar(env, CommonUtil.queryInventoryCarMaintenanceTaskStatus), token, params);
        Response<Object> response = DstJsonUtil.toObject(result, Response.class);
        return response;
    }

    /**
     * 关联指定工单子表
     * @param env
     * @param token
     * @param params
     * @return
     */
    public static Response<Object> updateDstBpmInstData(String env, String token, Object params) {
        String result = HttpUtils.doPost(getInstance(env, CommonUtil.updateDstBpmInstData), token, params);
        Response<Object> response = DstJsonUtil.toObject(result, Response.class);
        return response;
    }

    /**
     * 质检工单，同步异常描述到主表单
     * @param env
     * @param token
     * @param params
     * @return
     */
    public static Response<Object> qualityWorkOrderSyncFaultDesc(String env, String token, Object params) {
        String result = HttpUtils.doPost(getInstance(env, CommonUtil.qualityWorkOrderSyncFaultDesc), token, params);
        Response<Object> response = DstJsonUtil.toObject(result, Response.class);
        return response;
    }


    public static PageDTO<Object> queryWorkOrderDataListByFormAlias(String env, String token, Object params) {
        String result = HttpUtils.doPost(getInstance(env, CommonUtil.queryWorkOrderDataListByFormAlias), token, params);
        Response<PageDTO<Object>> response = DstJsonUtil.toObject(result, Response.class);

        return DstJsonUtil.toObject(response.getData(), PageDTO.class);
    }

    public static PageDTO<Object> submitWorkorder(String env, String token, Object params) {
        String result = HttpUtils.doPost(getInstance(env, CommonUtil.submitWorkorder), token, params);
        Response<PageDTO<Object>> response = DstJsonUtil.toObject(result, Response.class);

        return DstJsonUtil.toObject(response.getData(), PageDTO.class);
    }

    public static Response<Object> doMaintainOrderConsumer(String env, String token, Object params) {
        String result = HttpUtils.doPost(getInstance(env, CommonUtil.doMaintainOrderConsumer), token, params);
        return DstJsonUtil.toObject(result, Response.class);
    }
}
