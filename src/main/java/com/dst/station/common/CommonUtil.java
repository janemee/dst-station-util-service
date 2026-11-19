package com.dst.station.common;

public class CommonUtil {
    public static final String TOKEN = "ied6f9c0fe5cf4c09b69772db6bf22249";
    public static final String URL_HEADER = "https://eportal-admin.dstcar.com";
    public static final String URL = "/dst-apis/workorder-base/auth//base/workorder/form/queryFormDataForList";
    public static final String SUB_URL = "/dst-apis/workorder-base/auth/base/workorder/inner/getTaskButtonsFormData";
    /**
     * 工单表数据更新
     */
    public static final String updateWorkOrderTableData = "/dst-apis/workorder-base/auth/base/workorder/inner/updateWorkOrderTableData";
    /**
     * 思倍云工单创建后同步至派单中心
     */
    public static final String syncWorkOrderDataToDispatch = "/dst-apis/workorder-base/public/base/workorder/open/public/syncWorkOrderDataToDispatchCenter";

    /**
     * 分页查询工单表单数据
     */
    public static final String getFormObjectDataListByPage = "/dst-apis/workorder-base/auth/base/workorder/inner/getFormObjectDataListByPage";

    /**
     * 派单中心 - 转派处理人
     */
    public static String transferWorkOrder = "/dst-apis/workorder-dispatch/auth/workOrder/dispatch/transferWorkOrder";
    /**
     * 维保 工单处理人
     */
    public static String updateWorkOrderHandlePerson = "/dst-apis/workorder-base/auth/base/workorder/inner/updateWorkOrderHandlePerson";

    /**
     * 创建后同步派单中心
     */
    public static String syncWorkOrderAfterCreate = "/dst-apis/workorder-dispatch/auth/workOrder/dispatch/syncWorkOrderAfterCreate";

    /**
     * 更新派单中心 数据
     */
    public static String syncWorkOrderUpdateData = "/dst-apis/workorder-dispatch/auth/workOrder/dispatch/syncWorkOrderUpdateData";

    /**
     * 重新执行派单策略
     */
    public static String manualExecuteDispatchStrategy = "/dst-apis/workorder-dispatch/auth/workOrder/dispatch/manualExecuteDispatchStrategy";

    /**
     * 查询派单中心数据列表
     */
    public static String queryDataPoolDataByPage= "/dst-apis/workorder-dispatch/auth/workOrder/dispatch/queryDataPoolDataByPage";

    /**
     * 查询派单中心数据列表 异常数据
     */
    public static String queryDataPoolDataByError= "/dst-apis/workorder-dispatch/auth/workOrder/dispatch/queryErrorRecords";


    /**
     * 查询派单中心处理人
     */
    public static String queryWorkOrderDispatchUser = "/dst-apis/workorder-dispatch/public/open/workOrder/dispatch/queryWorkOrderDispatchUser";



    /**
     * 技改工单，更新车辆属性
     */
    public static String technicalTransformationUpdateCarAttribute = "/dst-apis/station-deliver/auth/sby/technicalTransformationUpdateCarAttribute";

    /**
     *  技改工单，技改验收-更新尾板信息  updateTailBoard
     */
    public static String updateTailBoard = "/dst-apis/station-deliver/auth/sby/updateTailBoard";

    /**
     * 技改工单，提交Iot设备编号
     */
    public static String submitIotDeviceCode = "/dst-apis/station-deliver/auth/sby/submitIotDeviceCode";

    /**
     * 质检工单 场站支持批量创建质检工单
     */
    public static String createQualityWorkOrders = "/dst-apis/station-deliver/auth/sby/createQualityWorkOrders";


    /**
     * 根据工单编码查询工单详情
     */
    public static String queryWorkOrderDetailByOrderCode = "/dst-apis/workorder-base/auth/base/workorder/detail/{orderCode}";

    /**
     * 维修验车工单完成-通知售后
     */
    public static String notifyAfterRepairVerification = "/dst-apis/1/vehicleOperate/openapi/common/updateMaintainOrder2Complete";

    /**
     * 查询库存车维保任务状态
     */
    public static String queryInventoryCarMaintenanceTaskStatus = "https://portal-car-center.dstcar.com/dst-apis/1/repair-apis/mtc/work/order/work-order-list";



    /**
     * 【通用】工单管理指定工单子表（详情展示）
     */
    public static String updateDstBpmInstData = "/dst-apis/workorder-base/public/base/workorder/updateDstBpmInstData";


    /**
     * 【质检工单】-更新故障描
     */
    public static String qualityWorkOrderSyncFaultDesc = "/dst-apis/station-deliver/public/sby/qualityWorkOrderSyncFaultDesc";


    /**
     * 根据表单别名查询思倍云工单数据列表
     */
    public static String queryWorkOrderDataListByFormAlias = "/dst-apis/workorder-base/auth/base/workorder/form/queryFormData";


    /**
     * 创建思倍云工单
     */
    public static String submitWorkorder = "/dst-apis/workorder-base/auth/base/workorder/submitWorkorder";

    /**
     * 维保单完成创建维修单MQ
     */
    public static String doMaintainOrderConsumer = "/dst-apis/1/vehicleOperate/sby/doMaintainOrderConsumer";
}
