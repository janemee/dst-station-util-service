package com.dst.station.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


/**
 * @description: 无订单退车工单
 * @author: yyp
 * @date: 2024/9/9 19:28
 */
@Data
public class BackcarNoOrdersVO {

    /**
     * 退车单编码
     */
    @JsonProperty(value="F_ORDERCODE")
    private String orderCode;

    /**
     * 车架号
     */
    @JsonProperty(value="F_VIN")
    private String vinCode;

    /**
     * 工单状态
     */
    @JsonProperty(value="BUSINESS_STATE")
    private String statusName;

    @JsonProperty(value="CREATE_TIME_")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @JsonProperty(value="FINISH_TIME")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date finishTime;

    @JsonProperty(value="F_STATIONID")
    private Integer stationId;

    /**
     * 质检结果
     */
    @JsonProperty(value="F_QUALITYRESULT")
    private String qualityResult;


    /**
     * 发起质检的关联单据
     */
    @JsonProperty(value="F_RELATIONORDERCODE")
    private String relationOrderCode;

    /**
     * 关联单据来源
     */
    @JsonProperty(value = "F_RELATIONORDERTYPE")
    private String relationOrderType;
}
