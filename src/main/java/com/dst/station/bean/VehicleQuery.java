package com.dst.station.bean;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 车辆信息查询参数
 * @author anguangjie@dstcar.com
 * @date 2023-08-15 21:05:37
 * @version 1.0
 */
@Data
public class VehicleQuery {

    /**
     * 车架号
     */
    @NotNull(message = "车架号不能为空")
    private String vinCode;

    /**
     * 车架号列表
     */
    private List<String> vinCodes;

    /**
     * 属性key
     */
    private List<String> attrKeys;
}
