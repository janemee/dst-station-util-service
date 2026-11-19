package com.dst.station.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @description: 工单-技改工单VO
 * @author: jzm
 * @date: 2025/12/19 13:45
 */
@Data
public class TechnicalModificationWorkOrderVO implements Serializable {
    /**
     * 技改类型 1 安装 2 拆除
     */
    @JsonProperty(value= "F_REFITTYPE")
    private String refitType;

    /**
     * 技改项 refitItem
     */
    @JsonProperty(value= "F_REFITITEM")
    private String refitItem;

    /**
     * 车架号
     */
    @JsonProperty(value= "F_VINCODE")
    private String vinCode;
    /**
     * 运营城市id
     */
    @JsonProperty(value= "F_CITYID")
    private String cityId;
    /**
     * 场站 ID
     */
    @JsonProperty(value= "F_STATION")
    private String stationId;
    /**
     * 车身颜色
     */
    @JsonProperty(value= "F_A_CAR_COLOR")
    private String carColor;
    /**
     * 尾板状态
     */
    @JsonProperty(value= "F_AK_A_CAR_ENDURANCE")
    private String tailBoardStatus;
    /**
     * 尾板品牌
     */
    @JsonProperty(value= "F_A_TAIL_BOARD_BRAND")
    private String tailBoardBrand;
    /**
     * 尾板护栏
     */
    @JsonProperty(value= "F_A_OPT_TAILBOARD_GUARDRAIL")
    private String tailBoardBarrier;
    /**
     * 冷机制热模块
     */
    @JsonProperty(value= "F_A_OPT_CHILLER_HEAT_MODULE")
    private String coldMechanismHeatModule;
    /**
     * 温感主机
     */
    @JsonProperty(value= "F_A_OPT_HEAT_DETECTION_CONTROL_PANEL")
    private String heatDetectionControlPanel;
    /**
     * 厢体技改
     */
    @JsonProperty(value= "F_A_TECHMOD_CARGO_BOX")
    private String tailBoardRefit;
    /**
     * 加装设备
     */
    @JsonProperty(value= "F_A_TECHMOD_ADD_EQUIPMENT")
    private String addEquipment;
    /**
     * 智能车载设备
     */
    @JsonProperty(value= "F_AK_A_CAR_TERMINAL")
    private String intelligentCarEquipment;
    /**
     * 温感探头数量
     */
    @JsonProperty(value= "F_A_TECHMOD_TEMP_SENSORS")
    private String tempSensorNumber;
    /**
     * 温感探头品牌
     */
    @JsonProperty(value= "F_A_TECHMOD_TEMP_SENSOR_BRAND")
    private String tempSensorBrand;
    /**
     * 冷藏风道长度
     */
    @JsonProperty(value= "F_A_TECHMOD_COLD_AIR_DUCT_ASSEMBLY")
    private String tckAirDuctLength;
    /**
     * 冷藏门帘位置
     */
    @JsonProperty(value= "F_A_TECHMOD_COLD_DOOR_CURTAIN")
    private String refrigerationCurtainPosition;
    /**
     * 冷厢隔温板数量
     */
    @JsonProperty(value= "F_A_TECHMOD_INSULATION_PANEL")
    private String coldBoxSeparationTemperatureBoardNumber;
    /**
     * 侧板挡风槽
     */
    @JsonProperty(value= "F_A_TECHMOD_SIDE_PANEL_AIR_DUCT")
    private String sidePanelDoorSlot;
    /**
     * 铝地台
     */
    @JsonProperty(value= "F_A_TECHMOD_ALUMINUM_PLATFORM")
    private String aluminaPlatform;
    /**
     * 医药冷箱倒流风罩
     */
    @JsonProperty(value= "F_A_TECHMOD_AIR_DEFLECTOR_HOOD")
    private String medicineColdBoxDownstreamWindShield;
    /**
     * 货厢撑杆数量
     */
    @JsonProperty(value= "F_A_TECHMOD_CARGO_BOX_SUPPORT_ROD")
    private String cargoRodNumber;
    /**
     * 蒸发器
     */
    @JsonProperty(value= "F_A_TECHMOD_EVAPORATOR")
    private String evaporator;
    /**
     * 门磁探头数量
     */
    @JsonProperty(value= "F_A_OPT_DOOR_MAGNETIC_SENSORS")
    private String doorMagnetSensorNumber;

}
