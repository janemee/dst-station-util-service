package com.dst.station.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 车辆运营信息
 * @author anguangjie@dstcar.com
 * @date 2023-08-17 19:05:57
 * @version 1.0
 */
@Data
public class VehicleOperatingVO {

    /**
     * carId
     */
    private Integer carId;

    private String dvgCode;

    /**
     * 一级库位编码
     */
    private String garageStateCode1st;
    private String garageStateCode1stName;

    /**
     * 二级库位编码
     */
    private String garageStateCode2nd;
    private String garageStateCode2ndName;

    /**
     * 服务组织-城市编码
     */
    private String serveCityCode;
    private String serveCityCodeName;

    /**
     * 服务组织-大区
     */
    private String orgCode;
    private String serveRegionName;

    /**
     * 归属场站id
     */
    private Integer stationId;
    private String stationName;

    /**
     * 主数据记录时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * 车辆停放围栏编码
     */
    private String fenceNo;

    /**
     * 车辆停放围栏名称
     */
    private String fenceName;

    /**
     * 金融服务
     */
    private String financialServices;
    private String financialServiceNames;

    /**
     * 车辆标签
     */
    private String carLabelIds;
    private String carLabel;
}
