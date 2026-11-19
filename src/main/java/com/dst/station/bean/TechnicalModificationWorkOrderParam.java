package com.dst.station.bean;

import lombok.Data;

import java.util.List;

/**
 * 更新技改工单车辆属性-请求参数
 *
 * @description: 工单-技改工单
 * @author: jzm
 * @date: 2025/12/19 13:45
 */
@Data
public class TechnicalModificationWorkOrderParam {

    /**
     * 工单编码
     */
    private List<String> orderCodeList;

    /**
     * 环境
     */
    private String env;
    /**
     * token
     */
    private String token;
}
