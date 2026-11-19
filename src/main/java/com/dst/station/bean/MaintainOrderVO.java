package com.dst.station.bean;

import lombok.Data;

/**
 * @author yuwei@dstcar.com
 * @version 1.0
 * @date 2025-08-19 18:27:27
 */
@Data
public class MaintainOrderVO {
    /**
     * 车架号
     */
    private String vinCode;
    /**
     * 小超维修订单编码
     */
    private String repairOrderCode;
    /**
     * 库存车维修订单编码
     */
    private String inventoryRepairOrderCode;
    /**
     *
     */
    private String userId;
    /**
     *
     */
    private String realName;

    public WorkOrderNoticeVO toNoticeVo() {
        WorkOrderNoticeVO noticeVO = new WorkOrderNoticeVO();
        noticeVO.setOrder_code(getRepairOrderCode());
        noticeVO.setWork_order_sn(getInventoryRepairOrderCode());
        noticeVO.setVin_code(getVinCode());
        return noticeVO;
    }
}