package com.dst.station.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 工单池数据实体类
 * 包含工单池基本信息和其对应的字段配置信息
 */
@Data
@NoArgsConstructor
public class DataPoolDataDO implements Serializable {
    private static final long serialVersionUID = 1L;

    
    private String _id;

    /**
     * 工单类型编码
     */
    private String typeCode;

    /**
     * 工单类型名称
     */
    private String typeName;

    /**
     * 业务技能
     */
    private String businessSkill;

    /**
     * 工单编码
     */
    private String workOrderCode;

    /**
     * 工单状态：0 指派中 1 处理中 2 已完成 3 已取消
     */
    private Integer workOrderStatus;

    /**
     * 业务工单编码
     */
    private String businessOrderCode;

    /**
     * 业务工单状态
     */
    private String businessOrderStatus;

    /**
     * 处理人 地上铁用户ID
     */
    private List<String> handleUserIds;

    /**
     * 处理人名称
     */
    private List<String> handleUserNames;

    /**
     * 处理人数量
     */
    private Integer handleUserCount;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * 完成时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date finishTime;

    /**
     * 取消时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date cancelTime;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    /**
     * 动态字段数据
     */
    private Map<String, Object> dynamicData;

    /**
     * 表名
     */
    private String tableName;
}
