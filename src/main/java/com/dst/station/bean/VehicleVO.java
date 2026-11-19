package com.dst.station.bean;

import lombok.Data;

/**
 * 车辆信息
 * @author anguangjie@dstcar.com
 * @date 2023-08-15 20:56:07
 * @version 1.0
 */
@Data
public class VehicleVO {

    /**
     * 运营信息
     */
    private VehicleOperatingVO vehicleOperating;

    /**
     * 公告号
     */
    private String noticeNo;
}
