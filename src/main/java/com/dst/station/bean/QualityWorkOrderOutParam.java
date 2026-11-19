// AiAutoGenerateStart_3a7b9c8d4e5f6g1h2i9j0k3l8m5n7o2Q
package com.dst.station.bean;

import lombok.Data;

/**
 * 发起质检工单参数
 */
@Data
public class QualityWorkOrderOutParam {

    /**
     * 场站ID
     */
    private Integer stationId;

    /**
     * 类型 1新车入库质检 2新车上牌 3车辆退车 4车辆调拨调入 5车辆质量巡检工单 6维修验车 7车辆整备 8定时任务
     */
    private String type;

    /**
     * 车架号
     */
    private String vinCode;

    /**
     * 车牌号
     **/
    private String plateNumber;

    /**
     * 关联订单编码
     */
    private String relationOrderCode;

    /**
     * 关联订单类型
     */
    private String relationOrderType;

    /**
     * 质检类型
     */
    private String qType;

    /**
     * 质检结果 1合格 2不合格
     */
    private String qualityResult;
}
// AiAutoGenerateEnd_3a7b9c8d4e5f6g1h2i9j0k3l8m5n7o2Q
