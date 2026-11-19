// AiAutoGenerateStart_3a7b9c8d4e5f6g1h2i9j0k3l8m5n7o2Q
package com.dst.station.bean;

import lombok.Data;

/**
 * 发起质检工单参数
 */
@Data
public class QualityWorkOrderUpdateParam {
    /**
     * 工单编码
     */
    private String orderCode;
    /**
     * 异常描述
     */
    private String faultDescription;

}
