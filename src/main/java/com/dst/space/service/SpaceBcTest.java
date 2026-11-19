package com.dst.space.service;

import com.dst.station.bean.WorkOrderDetailDTO;
import com.dst.station.service.SbyService;
import com.dst.steed.common.domain.response.Response;
import com.dst.steed.common.util.DstJsonUtil;

import java.util.HashMap;

public class SpaceBcTest {
    public static String token = "ied06afa0bc3e41b0a2a304355d28af01";

    public static void main(String[] args) {
        wxycOrder();
    }

    public static void wxycOrder() {
        String content = "WXHYS0521791278570807\n" +
                "WXHYS0521791188736370\n" +
                "WXHYS0521791171903415\n" +
                "WXHYS0521791092836841\n" +
                "WXHYS0521790991556584\n" +
                "WXHYS0521790926563358\n" +
                "WXHYS0521790822848900\n" +
                "WXHYS0521790769137845\n" +
                "WXHYS0521790760065271\n" +
                "WXHYS0521790754799425\n" +
                "WXHYS0521790676402017";

        String cc = "        GD1297689125847556096\t55\n" +
                "        GD1322936805720973312\t55\n" +
                "        GD1321778875801919488\t55";
        //查询工单
        String[] orderCodes = content.split("\n");
        for (String orderCode : orderCodes) {
            Response<WorkOrderDetailDTO> response = SbyService.queryWorkOrderDetailByOrderCode("prod", token, orderCode);
            WorkOrderDetailDTO detailDTO = DstJsonUtil.toObject(response.getData(), WorkOrderDetailDTO.class);
            String vinCode = (String) detailDTO.getWorkOrderInfo().getData().get("vinCode");
            String repairOrderCode = (String) detailDTO.getWorkOrderInfo().getData().get("repairOrderCode");
            String inventoryRepairOrderCode = (String) detailDTO.getWorkOrderInfo().getData().get("inventoryRepairOrderCode");
            HashMap<String, Object> tableDataMap = new HashMap<>();
            tableDataMap.put("vin_code", vinCode);
            tableDataMap.put("order_code", repairOrderCode);
            tableDataMap.put("work_order_sn", inventoryRepairOrderCode);
            if (cc.contains(inventoryRepairOrderCode)) {
                System.out.println("包含:" + inventoryRepairOrderCode);
                //通知售后完成工单
                Response<?> response2 = SbyService.notifyAfterCompletion("prod", token, tableDataMap);
                System.out.println(DstJsonUtil.toString(response2));
            }
        }
    }
}
