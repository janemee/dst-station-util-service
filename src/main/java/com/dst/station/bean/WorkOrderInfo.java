package com.dst.station.bean;

import cn.hutool.core.bean.BeanUtil;
import lombok.Data;

import java.util.Map;

@Data
public class WorkOrderInfo {

    /**
     * 工单编号
     */
    private String orderCode;

    /**
     * 父级工单编码：当该工单是子流程生成的，则有
     */
    private String parentOrderCode;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 工单状态
     */
    private String status;

    private String statusCode;

    //1-待受理，2-处理中，3-已完成，4-已取消
    private Integer processState;

    /**
     * 创建人员
     */
    private String creatorUser;
    private String creatorPersonCode;  //思倍云用户ID
    private String userId;  //地上铁用户ID

    /**
     * 处理人员信息，多个用逗号隔开
     */
    private String handlers;

    /**
     * 接单时间
     */
    private String acceptTime;

    /**
     * 工单实例
     */
    private String instId;
    private String taskId;


    private Map<String, Object> data;

    private String finishTime;

    private String cancelTime;

    /**
     * 工单类型名称
     */
    private String orderTypeId;
    private String typeName;
    private String typeCode;

    private String pkId;
    private String layout;
    private String extInfo;

    /**
     * 思倍云工单信息转换成界面显示信息
     *
     * @param spaceWorkOrderInfo
     * @return
     */
    public static WorkOrderInfo orderTransfer(SpaceWorkOrderInfo spaceWorkOrderInfo) {
        WorkOrderInfo workOrder = new WorkOrderInfo();
        BeanUtil.copyProperties(spaceWorkOrderInfo, workOrder);
        workOrder.setHandlers(spaceWorkOrderInfo.getHandlers());
        return workOrder;
    }
}
