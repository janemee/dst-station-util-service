package com.dst.station.bean;


import cn.hutool.json.JSONUtil;
import lombok.Data;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 思倍云关联表单
 */
@Data
public class TaskButtonFormVo {

    /**
     * 表单id
     */
    private String formId;

    /**
     * 别名
     */
    private String alias;

    /**
     * 标题
     */
    private String title;

    /**
     * 数据
     */
    private Map<String, Object> data;

    /**
     * 将数据转为String
     * @return  string数据
     */
    public Map<String, String> getDataToStr(){
        if (data != null){
            Map<String, String> dataStrMap = new HashMap<>();
            //非string类型才转string，并加入到dataMap中
            data.forEach((key, value) -> {
                if (value instanceof String) {
                    dataStrMap.put(key, (String) value);
                } else {
                    dataStrMap.put(key, JSONUtil.toJsonStr((value)));
                }
            });
            return dataStrMap;
        }
        return Collections.emptyMap();
    }
}
