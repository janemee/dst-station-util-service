package com.dst.station.bean;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class SpaceFormDataQuery {

    /**
     * 分页序号
     */
    private Integer pageNo = 1;
    /**
     * 分页大小
     */
    private Integer pageSize = 10;
    /**
     * 排序字段
     */
    private String sortField;
    /**
     * 排序
     */
    private String sortOrder;

    /**
     * 映射参数，格式如：ORDER_ID_,Q_ORDER_ID_S_EQ 键值的映射
     * 查询参数都放在：params中。
     * Q_F_XM_S_EQ的意思：
     * Q_：代表查询。
     * _S：代表字符串。
     * _EQ：代表等于。
     * F_XM：代表数据字段名称。
     */
    private Map<String, String> params = new HashMap<>();

    /**
     * 表单列表名称
     */
    private String formListName;

    public void addParams(String paramName, String value){
        params.put(paramName, value);
    }
}
