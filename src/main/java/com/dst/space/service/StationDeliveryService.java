package com.dst.space.service;

import com.dst.station.service.SbyService;

public class StationDeliveryService {

    public static String env = "prod";
    public static String token = "i46a5da9080e74493a40a77ad7c55479f";

    public static void main(String[] args) {
        String orderCodeStr = "CLJGGD891786617675875\n" +
                "CLJGGD891786615687951\n" +
                "CLJGGD891786612805706\n" +
                "CLJGGD891786612805709\n" +
                "CLJGGD891786612805702\n" +
                "CLJGGD891786612805713\n" +
                "CLJGGD891786607499244\n" +
                "CLJGGD891786607499219\n" +
                "CLJGGD891786607499195\n" +
                "CLJGGD891786607499170\n" +
                "CLJGGD891786607499145\n" +
                "CLJGGD891786606696163\n" +
                "CLJGGD891786600971448\n" +
                "CLJGGD891786592222970\n" +
                "CLJGGD891786586692076\n" +
                "CLJGGD891786520712661\n" +
                "CLJGGD891786520712664\n" +
                "CLJGGD891786496987393\n" +
                "CLJGGD891785985387911\n" +
                "CLJGGD891785981105120\n" +
                "CLJGGD891785981105094\n" +
                "CLJGGD891785981105017\n" +
                "CLJGGD891785981104908\n" +
                "CLJGGD891785981104883\n" +
                "CLJGGD891761275588295";
        String[] strings = orderCodeStr.split("\n");
        for (String orderCode : strings) {
            SbyService.technicalTransformationUpdateCarAttribute(env, token, orderCode);
            SbyService.updateTailBoard(env, token, orderCode);
            SbyService.submitIotDeviceCode(env, token, orderCode);
        }
    }
}
