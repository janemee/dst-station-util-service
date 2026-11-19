package com.dst.station.req;

import lombok.Data;

@Data
public class VehicleAttrSyncReq {
    //环境
    private String env;
    //token
    private String token;
    //工单编码
    private String orderCode;
}
