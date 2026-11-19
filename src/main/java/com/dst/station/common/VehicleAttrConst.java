package com.dst.station.common;

import java.util.Arrays;
import java.util.List;

/**
 * @Description 车辆属性key常量管理类
 * @author liuweiping@dstcar.com
 * @version 1.0
 * @date 2023-04-27 15:57:20
 */
public class VehicleAttrConst {


    /**
     * 车辆品牌key
     */
    public static final String AK_G_CAR_BRAND = "AK_G_CAR_BRAND";

    /**
     * 车辆资产分类属性key
     */
    public static final String A_OPT_ASSET_CLASSIFY = "A_OPT_ASSET_CLASSIFY";

    /**
     * 资产评级属性key
     */
    public static final String A_OPT_BASIC_ASSET_RATING = "A_OPT_BASIC_ASSET_RATING";

    /**
     * 采购入库时间
     */
    public static final String A_PUTIN_STORAGE_DATE = "A_PUTIN_STORAGE_DATE";
    /**
     * 行驶公里数属性key
     */
    public static final String A_OPT_DRIVING_KILO = "A_OPT_DRIVING_KILO";
    /**
     * 车辆型号key
     */
    public static final String AK_G_CAR_MODEL = "AK_G_CAR_MODEL";
    /**
     * 车辆颜色key
     */
    public static final String A_CAR_COLOR = "A_CAR_COLOR";

    /**
     * 归属运营公司
     */
    public static final String A_CAR_OPT_COMPANY = "A_CAR_OPT_COMPANY";

    /**
     * 上牌年份属性key
     */
    public static final String VEHICLE_REGISTRATION_YEAR_ATTR_KEY = "A_REGISTRATION_YEAR";

    /**
     * 总质量（kg）
     */
    public static final String A_TOTAL_MASS = "A_TOTAL_MASS";

    /**
     * 车型族群
     */
    public static final String AK_A_CAR_MODEL_GROUP = "AK_A_CAR_MODEL_GROUP";

    /**
     * 车辆用途
     */
    public static final String A_OPT_VEHICLE_USE = "A_OPT_VEHICLE_USE";

    /**
     * 商业险保单使用性质 key
     */
    public static final String A_COMMERCIAL_INSURANCE_USAGE = "A_COMMERCIAL_INSURANCE_USAGE";

    /**
     * 预占状态的属性key
     */
    public static final String PREEMPT_STATUS_ATTR_KEY = "A_OPT_FROZEN_STATUS";

    /**
     * 尾板状态
     */
    public static final String AK_A_CAR_ENDURANCE = "AK_A_CAR_ENDURANCE";
    /**
     * 尾板品牌
     */
    public static final String A_TAIL_BOARD_BRAND = "A_TAIL_BOARD_BRAND";
    /**
     * 尾板护栏
     */
    public static final String A_OPT_TAILBOARD_GUARDRAIL = "A_OPT_TAILBOARD_GUARDRAIL";
    /**
     * 冷机制热模块
     */
    public static final String A_OPT_CHILLER_HEAT_MODULE = "A_OPT_CHILLER_HEAT_MODULE";
    /**
     * 温感主机
     */
    public static final String A_OPT_HEAT_DETECTION_CONTROL_PANEL = "A_OPT_HEAT_DETECTION_CONTROL_PANEL";
    /**
     * 厢体技改
     */
    public static final String A_TECHMOD_CARGO_BOX = "A_TECHMOD_CARGO_BOX";
    /**
     * 加装设备
     */
    public static final String A_TECHMOD_ADD_EQUIPMENT = "A_TECHMOD_ADD_EQUIPMENT";
    /**
     * 智能车载设备
     */
    public static final String A_OPT_CAR_TERMINAL = "AK_A_CAR_TERMINAL";
    /**
     * 温感探头数量
     */
    public static final String A_TECHMOD_TEMP_SENSORS = "A_TECHMOD_TEMP_SENSORS";
    /**
     * 温感探头品牌
     */
    public static final String A_TECHMOD_TEMP_SENSOR_BRAND = "A_TECHMOD_TEMP_SENSOR_BRAND";
    /**
     * 冷藏风道长度
     */
    public static final String A_TECHMOD_COLD_AIR_DUCT_ASSEMBLY = "A_TECHMOD_COLD_AIR_DUCT_ASSEMBLY";
    /**
     * 冷藏门帘位置
     */
    public static final String A_TECHMOD_COLD_DOOR_CURTAIN = "A_TECHMOD_COLD_DOOR_CURTAIN";
    /**
     * 冷厢隔温板数量
     */
    public static final String A_TECHMOD_INSULATION_PANEL = "A_TECHMOD_INSULATION_PANEL";
    /**
     * 侧板挡风槽
     */
    public static final String A_TECHMOD_SIDE_PANEL_AIR_DUCT = "A_TECHMOD_SIDE_PANEL_AIR_DUCT";
    /**
     * 铝地台
     */
    public static final String A_TECHMOD_ALUMINUM_PLATFORM = "A_TECHMOD_ALUMINUM_PLATFORM";
    /**
     * 医药冷箱倒流风罩
     */
    public static final String A_TECHMOD_AIR_DEFLECTOR_HOOD = "A_TECHMOD_AIR_DEFLECTOR_HOOD";
    /**
     * 货厢撑杆数量
     */
    public static final String A_TECHMOD_CARGO_BOX_SUPPORT_ROD = "A_TECHMOD_CARGO_BOX_SUPPORT_ROD";
    /**
     * 蒸发器
     */
    public static final String A_TECHMOD_EVAPORATOR = "A_TECHMOD_EVAPORATOR";
    /**
     * 门磁探头数量
     */
    public static final String A_OPT_DOOR_MAGNETIC_SENSORS = "A_OPT_DOOR_MAGNETIC_SENSORS";



    /**
     * 预占状态属性值id 无
     */
    public static final String PREEMPT_STATUS_NONE_VALUE_ID = "620297749153329153";

    /**
     * 商业险营运类
     */
    public static final List<String> A_COMMERCIAL_I_U_ENTERPRISE_OPERATED_VALUE = Arrays.asList("847512415106404352","847512415106404355");
    /**
     * 商业险非营运类
     */
    public static final List<String> A_COMMERCIAL_I_U_NON_ENTERPRISE_OPERATED_VALUE = Arrays.asList("847512415106404353","847512415106404354");

    /**
     * 交强险保单使用性质 key
     */
    public static final String A_COMPULSORY_INSURANCE_USAG = "A_COMPULSORY_INSURANCE_USAGE";

    /**
     * 交强险营运类
     */
    public static final List<String> A_COMPULSORY_I_U_ENTERPRISE_OPERATED_VALUE = Arrays.asList("847512874768568321","847512874768568324");
    /**
     * 交强险非营运类
     */
    public static final List<String> A_COMPULSORY_I_U_NON_ENTERPRISE_OPERATED_VALUE = Arrays.asList("847512874768568322","847512874768568323");

    /**
     * 车辆预占状态属性id
     */
    public static final String A_OPT_FROZEN_STATUS = "A_OPT_FROZEN_STATUS";

    /**
     * 车辆预占状态:无 属性值id
     */
    public static final String VEHICLE_PREEMPT_STATUS_ATTR_VALUE_ID = "620297749153329153";


    /**
     * 车辆属性变更mq
     */
    public static final String CAR_ATTR_CHANGE_EXCHANGE = "car-attr-change-exchange";
    public static final String CAR_ATTR_CHANGE_QUEUE = "car-attr-change-queue";
    public static final String CAR_ATTR_CHANGE_ROUTING_KEY = "car.attr.change.routing.key";

    /**
     * 技改工单-技改类型 安装：1 拆除 ：2
     */
    public static final String TECH_CHANGE_TYPE_INSTALL = "1";
    public static final String TECH_CHANGE_TYPE_TEAR_DOWN = "2";

}
