package com.dst.space.bean;

import lombok.Data;

import java.util.List;

@Data
public class SpaceSyncParam {
    /**
     * 环境
     */
    private String env;
    /**
     * token
     */
    private String token;
    /**
     * 工单编码
     */
    private List<String> orderCodes;
    /**
     * 派单类型编码
     */
    private String dispatchOrderTypeCode;
}
