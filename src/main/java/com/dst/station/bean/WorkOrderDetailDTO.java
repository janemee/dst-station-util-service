package com.dst.station.bean;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 工单详情， 包括工单对象，工单主表单对象以及节点关联表单对象
 */
@Data
public class WorkOrderDetailDTO {

    /**
     * 工单信息
     */
    private WorkOrderInfo workOrderInfo;

    /**
     * 工单关联表单信息
     */
    private List<SpaceFormData> formDatas = new ArrayList<>();
}
