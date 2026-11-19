package com.dst.station.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @description: 工单-技改工单-技改验收表单信息
 * @author: jzm
 * @date: 2025/12/19 13:45
 */
@Data
public class TechnicalModificationWorkOrderSubVO {
    /**
     * 尾板编码
     */
    @JsonProperty(value= "wbbm")
    private String tailBoardCode;
    /**
     * 尾板品牌
     */
    @JsonProperty(value= "wbpp")
    private String tailBoardBrand;
    /**
     * 尾板sku
     */
    @JsonProperty(value= "wbSku")
    private String tailBoardSku;
}
