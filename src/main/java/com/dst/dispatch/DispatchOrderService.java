package com.dst.dispatch;

import com.dst.station.common.HttpUtils;
import com.dst.station.service.SbyService;
import com.dst.steed.common.domain.response.ResponseWrapper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DispatchOrderService {


    public ResponseWrapper dispatchOrderSync(List<String> orderCodes) {
        return ResponseWrapper.succeed();

    }


    //指派处理人
    public static ResponseWrapper dispatchOrder(String typeCode, String orderCode, String userId, String userName) {
        List<String> orderCodes = Arrays.asList(orderCode.split(","));
        List<String> userIds = Arrays.asList(userId.split(","));
        List<String> userNames = Arrays.asList(userName.split(","));
        String path = "/dst-apis/workorder-dispatch/auth/workOrder/dispatch/transferWorkOrder";
        String token = "if6f8108c04e54b9bab6351545f898b64";
        Map<String, Object> params = new HashMap<>();
        params.put("orderCode", orderCodes);
        params.put("typeCode", typeCode);
        params.put("userIds", userIds);
        params.put("userNames", userNames);
        String result = HttpUtils.doPost(SbyService.getInstance("test", path), token, params);
        return ResponseWrapper.succeed(result);
    }

    public static void main(String[] args) {
        String content = "WBYYD0371775048974337\t965929239491362816\t刘丰豪\n";
        String[] split = content.split("\n");
        for (String s : split) {
            String[] split1 = s.split("\t");
            dispatchOrder("WBYYD037177504", split1[0], split1[1], split1[2]);

        }


    }

}
