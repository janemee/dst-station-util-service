package com.dst.space.service;

import com.dst.station.bean.MaintainOrderVO;
import com.dst.station.service.SbyService;
import com.dst.steed.common.util.DstJsonUtil;
import org.junit.Test;

import java.util.List;

public class StationTest {

    public static String env = "prod";
    public static String token = "i94b492470eb6453bacbb419a06178022";


    public static void main(String[] args) {
        WXZJMQ();
    }

    public static void WXZJMQ(){
        String mqStr = "{\"vinCode\":\"LM6BFBBX1NX339568\",\"repairOrderCode\":\"1185871062204235776\",\"inventoryRepairOrderCode\":\"GD1325905452236005376\",\"userId\":1173211914069401601,\"realName\":\"苏琳\"}";
//                "{\"vinCode\":\"LEWTEB14XPN100584\",\"repairOrderCode\":\"1198629089331941376\",\"inventoryRepairOrderCode\":\"GD1338800411007901696\",\"userId\":784445461970747394,\"realName\":\"李启其\"}\n" +
//                "{\"vinCode\":\"LZGCA2413SB016976\",\"repairOrderCode\":\"1195009211475726336\",\"inventoryRepairOrderCode\":\"GD1335242183112253440\",\"userId\":1056879219915214849,\"realName\":\"李甜\"}\n" +
//                "{\"vinCode\":\"LZGCA2416SB017703\",\"repairOrderCode\":\"1198643956621590528\",\"inventoryRepairOrderCode\":\"GD1338870821011709952\",\"userId\":617413738492067840,\"realName\":\"柯莹莹\"}\n" +
//                "{\"vinCode\":\"LM6BFBBX9NX340905\",\"repairOrderCode\":\"1198985352905367552\",\"inventoryRepairOrderCode\":\"GD1339198597828698112\",\"userId\":1196892844088066052,\"realName\":\"周敏捷\"}\n" +
//                "{\"vinCode\":\"LUEBABAG1PE512878\",\"repairOrderCode\":\"1199012148309213184\",\"inventoryRepairOrderCode\":\"GD1339250651997790208\",\"userId\":887282701636636673,\"realName\":\"辛博\"}\n" +
//                "{\"vinCode\":\"LZGCA2410SB004154\",\"repairOrderCode\":\"1199287271218036736\",\"inventoryRepairOrderCode\":\"GD1339524812804579328\",\"userId\":1761068097528768,\"realName\":\"张金金\"}\n" +
//                "{\"vinCode\":\"LA9BBJBR3MMLM6135\",\"repairOrderCode\":\"1199647598937673731\",\"inventoryRepairOrderCode\":\"GD1339889579629076480\",\"userId\":1053601726540099585,\"realName\":\"周丽\"}\n" +
//                "{\"vinCode\":\"LA9CKJ3R3N3LM6792\",\"repairOrderCode\":\"1199306222996111360\",\"inventoryRepairOrderCode\":\"GD1339264202313293824\",\"userId\":714865152913235970,\"realName\":\"杨春明\"}\n" +
//                "{\"vinCode\":\"HGLH3ACF7SA719542\",\"repairOrderCode\":\"1199412322801848320\",\"inventoryRepairOrderCode\":\"GD1339642720234627072\",\"userId\":995644872352976896,\"realName\":\"曾志伟\"}\n" +
//                "{\"vinCode\":\"LS6C8E046PE820384\",\"repairOrderCode\":\"1199403290116366336\",\"inventoryRepairOrderCode\":\"GD1339614238062665728\",\"userId\":891762842003697665,\"realName\":\"刘淳伟\"}\n" +
//                "{\"vinCode\":\"LZGCA2416SB011450\",\"repairOrderCode\":\"1199635042743697408\",\"inventoryRepairOrderCode\":\"GD1339624284318195712\",\"userId\":1051098845930270720,\"realName\":\"朱总\"}\n" +
//                "{\"vinCode\":\"LA9CKJ3R4NGLM6003\",\"repairOrderCode\":\"1199000850565046272\",\"inventoryRepairOrderCode\":\"GD1339231383990034432\",\"userId\":1063472213525209088,\"realName\":\"彭先生\"}\n" +
//                "{\"vinCode\":\"HGCH1KB68RZ033647\",\"repairOrderCode\":\"1198952042079010816\",\"inventoryRepairOrderCode\":\"GD1338548849673232384\",\"userId\":1126174677774233602,\"realName\":\"顺源\"}";

        String[] mqList = mqStr.split("\n");
        for (String s : mqList){
            MaintainOrderVO maintainOrderVO = DstJsonUtil.toObject(s, MaintainOrderVO.class);
            System.out.println(s);
            //请求场站接口
            SbyService.doMaintainOrderConsumer(env, token, maintainOrderVO);
        }
    }
}
