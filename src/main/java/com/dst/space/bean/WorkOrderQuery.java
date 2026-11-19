package com.dst.space.bean;

import com.dst.steed.common.domain.request.PageQuery;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class WorkOrderQuery {
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
    private String orderBy;
    /**
     * 排序：desc asc
     */
    private String orderType;

    /**
     * 查询参数
     * 基于数据库字段进行查询，全匹配，不支持模糊查询。
     * 格式如：{"REF_ID_": "1902713324779409409"}
     */
    private Map<String, String> queryParams = new HashMap<>();

    /**
     * 表单列表名称
     */
    private String formAlias;

    public void addParams(String paramName, String value) {
        queryParams.put(paramName, value);
    }
}
