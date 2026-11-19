package com.dst.station.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpaceWorkOrderDO {

    /**
     * 工单类型编码
     */
    private String orderTypeId;

    /**
     * 项目编码
     */
    private String projectCode;

    /**
     * 表单数据
     */
    private Object data;
}
