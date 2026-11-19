package com.dst.station.bean;

import lombok.Data;

/**
 * 尾板DTO
 */
@Data
public class TailBoardDTO {
    //尾板产品编码
    private String tailBoardCode;
    //尾板SKU编码
    private String skuCode;
    //服务组织城市编码
    private String serveCityCode;
    //绑定车架号 - 非必填
    private String bindVinCode;
}
