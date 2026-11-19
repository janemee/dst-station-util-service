package com.dst.station;

import lombok.Data;

import java.util.HashMap;

@Data
public class WbyydUpdatePresonReq {

    /**
     *
     */
    private String name;

    private HashMap <String, Object> executeParam;

}
