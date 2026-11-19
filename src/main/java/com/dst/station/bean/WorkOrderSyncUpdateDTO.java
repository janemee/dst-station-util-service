package com.dst.station.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 工单数据同步更新请求DTO
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkOrderSyncUpdateDTO implements Serializable {

    /**
     * 工单编码
     */
    private String workOrderCode;

    /**
     * 工单状态：0 指派中 1 处理中 2 已完成 3 已取消
     */
    private Integer workOrderStatus;

    /**
     * 业务工单编码
     */
    private String businessOrderCode;

    /**    * 业务工单状态
     */
    private String businessOrderStatus;

    /**
     * 处理人地上铁用户ID
     */
    private List<String> handleUserIds;

    /**
     * 处理人名称
     */
    private List<String> handleUserNames;

    /**
     * 时间戳
     */
    private Long timestamp;

    /**
     * 工单配置关键字段信息
     */
    private Map<String, Object> orderBusinessData;
}