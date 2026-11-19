package com.dst.station.common;

/**
 * 质检单常量
 * @author: fengshang
 * @date: 2023/11/2 15:19
 */
public class QualityChecklistConst {

    /**
     * 质检单创建、完成mq
     */
    public static final String QUALITY_CHECK_QUEUE = "quality-check-queue";

    /**
     * 新质检工单支持多场景发起
     */
    public static final String SBY_CREATE_QUALITY_WORK_ORDER_QUEUE = "sby_create_quality_work_order_queue";

    /**
     * 按车架号初始化质检单
     */
    public final static Integer QC_INIT_WAY_VIN_CODE = 1;

    /**
     * 按车牌号初始化质检单
     */
    public final static Integer QC_INIT_WAY_PLATE_NUMBER = 2;

    /**
     * 资产分类key
     */
    public final static String A_OPT_ASSET_CLASSIFY = "A_OPT_ASSET_CLASSIFY";

    /**
     * 质检单初始化返回校验失败
     */
    public final static Integer QC_INIT_RETURN_CHECK_FAIL = 1;

    /**
     * 质检单初始化返回初始化存在失败
     */
    public final static Integer QC_INIT_RETURN_INIT_FAIL = 2;

    /**
     * 质检单初始化返回初始化成功
     */
    public final static Integer QC_INIT_RETURN_INIT_SUCCESS = 3;

    /**
     * 质检类型字典
     */
    public static final String QC_TYPE = "qc_type";

    /**
     * 质检状态字典
     */
    public static final String QC_STATUS = "qc_status";

    /**
     * 质检单完结状态字典
     */
    public static final String QC_END_STATUS = "qc_end_status";

    /**
     * 质检结果字典
     */
    public static final String QC_RESULTS = "qc_results";

    /**
     * 质检不合格原因字典
     */
    public static final String QC_REASON = "qc_reason";


    /**
     * 质检单文件类型
     */
    public static final String QC_ATTACH_MENT_TYPE = "qualityChecklistRecord";

    /**
     * 质检单文件提交节点
     */
    public static final String QC_ATTACH_MENT_POINT = "qualityChecklistRecordUpload";

    /**
     * 质检单文件类型
     */
    public static final String QC_FAULT_ATTACH_MENT_TYPE = "qualityChecklistFaultAttachment";
    public static final String QC_FAULT_ATTACH_MENT_TYPE_NEW = "faultAttachmentNew";

    /**
     * 质检单文件提交节点
     */
    public static final String QC_FAULT_ATTACH_MENT_POINT = "faultAttachmentUpload";

    /**
     * 质检单创建库存车维修任务成功提示
     */
    public static final String QC_CREATE_MAINTENANCE_SUCCESS_MSG = "创建库存车维修任务成功，请前往对应系统执行!";


    /**
     * 质检单变更属性业务编码
     */
    public static final String QC_CHANGE_ATTR_BUS_CODE = "CZZJ20250507";

    /**
     * 成品库编码 type
     */
    public static final String PRODUCT_STOCK_TYPE = "product_stock";
    /**
     * 成品库编码 name
     *  */
    public static final String PRODUCT_STOCK_NAME = "成品库";

    /**
     * 质检工单进行中-时间配置
     * quality_work_order_time
     */
    public static final String QUALITY_WORK_ORDER_TIME_KEY = "quality_work_order_time";
    /**
     * 质检工单进行中-时间配置
     * quality_work_order_time
     */
    public static final String QUALITY_WORK_ORDER_TIME_NAME = "质检工单进行中-指定时间配置";

    /**
     * 车辆用途是否为裸车销售
     */
    public static final String VEHICLE_USAGE_IS_SALE = "1";
}
