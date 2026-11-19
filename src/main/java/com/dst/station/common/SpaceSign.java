package com.dst.station.common;

import lombok.Builder;
import lombok.Data;

/**
 * @description 思倍云加签信息
 */
@Data
@Builder
public class SpaceSign {

    /**
     * 当前时间戳
     */
    private String time;

    /**
     * 当前获取签名
     */
    private String signStr;
}
