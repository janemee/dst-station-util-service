package com.dst.station.bean;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Map;

/**
 * @Description 车辆主数据-属性变更
 * @Author pengyunlin
 * @Date 2023/5/30 16:27
 */
@Accessors(chain = true)
@Data
public class CarAttrChangeMessage implements Serializable {
    /**
     * 业务编码
     */
    private String busCode;

    /**
     * 车架号，批量修改时，格式为英文逗号分割的字符串
     */
    private String vinCodes;

    /**
     * 属性
     */
    private Object attrData;

    /**
     * 删除属性
     * key:属性id
     * value:属性value
     */
    private Map<String, Object> delAttrKeyAndValues;

    /**
     * 操作人id
     */
    private String operatorId;

    /**
     * 操作人名称
     */
    private String operatorName;

    /**
     *
     */
    private String remark;

}
