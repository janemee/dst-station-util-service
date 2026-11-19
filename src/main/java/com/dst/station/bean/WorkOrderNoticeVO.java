package com.dst.station.bean;

import lombok.Data;

/**
 * @author yuwei@dstcar.com
 * @version 1.0
 * @date 2025-08-20 15:58:30
 */
@Data
public class WorkOrderNoticeVO {
    /**
     * 车架号
     */
    private String vin_code;
    /**
     * 维保订单编码
     */
    private String order_code;
    /**
     * 库存车订单编码
     */
    private String work_order_sn;
}