package com.dst.station.service;

import cn.hutool.core.collection.CollectionUtil;
import com.dst.station.bean.CarAttrChangeMessage;
import com.dst.steed.common.util.DstDateUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CLZJOrderService {


    //质检工单-质检状态
    public void update(String evn, String token, String vinCode) {
        CarAttrChangeMessage message = new CarAttrChangeMessage();
        message.setBusCode("LYJG20250429");
        message.setVinCodes(vinCode);

        Map<String, String> attrData = new HashMap<>();
        //不合格
        attrData.put("A_OPT_LATEST_QI_REPORT_STATUS", "996003672457453569");
        attrData.put("A_OPT_LATEST_VEHICLE_STATUS", "996003140303757314");
        attrData.put("A_OPT_LATEST_QI_REPORT_DATE", DstDateUtil.formatDate(new Date()));

        //合格
        attrData.put("A_OPT_LATEST_QI_REPORT_STATUS", "996003672457453569");
        attrData.put("A_OPT_LATEST_VEHICLE_STATUS", "996003140303757313");
        //整备状态
        attrData.put("A_OPT_LATEST_VEHICLE_STATUS", "996003140303757312");
        attrData.put("A_OPT_LATEST_QI_REPORT_DATE", DstDateUtil.formatDate(new Date()));

        if (CollectionUtil.isNotEmpty(attrData)) {
            message.setOperatorId("0205363439694716");
            message.setOperatorName("吴杰");
            message.setRemark("质检-更新车辆属性");
            //调用车辆修改属性mq
        }
        message.setAttrData(attrData);
        SbyService.updateVehicleAttrByMq(evn, token, message);
    }
}
