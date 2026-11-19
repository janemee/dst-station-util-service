package com.dst.station.bean;

import lombok.Data;

import java.util.Map;

/**
 * 子表单数据更新请求
 */
@Data
public class SubUpdateDstBpmInstDataParams {
    /**
     * 子表单别名
     */
    private String alias;
    /**
     * 子表单数据ID
     */
    private String dataId;
    /**
     * 工单编码-关联工单编码
     */
    private String orderCode;

    /**
     * 异常描述
     */
    private String faultDescription;
    /**
     * 工单编码-关联工单编码
     */
    private String newOrderCode;
    /**
     * 工单编码-原工单编码
     */
    private String oldOrderCode;
    /**
     * 是否确定更新
     * true: 确定更新
     * false: 取消更新
     * 默认值：false
     */
    private Boolean isUpdate = false;

    /**
     * 子表数据-数据对象
     */
    private Map<String, Object> data;
}
