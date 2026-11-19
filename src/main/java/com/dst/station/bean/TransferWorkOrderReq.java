package com.dst.station.bean;

import lombok.Data;

import java.util.List;

@Data
public class TransferWorkOrderReq {

    private List<String> orderCodes;

    private List<String> userIds;

    private List<String> userNames;
}
