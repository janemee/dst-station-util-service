package com.dst.station.bean;

import com.dst.steed.common.domain.request.PageQuery;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 工单池动态查询请求DTO
 */
@Data
public class DataPoolDataQuery extends PageQuery {
    
    /**
     * 工单池编码
     */
    private String dataPoolCode;
    
    /**
     * 创建开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createStartTime;
    
    /**
     * 创建结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createEndTime;
    
    /**
     * 业务工单类型编码集合，支持多选
     */
    private List<String> typeCodes;
    
    /**
     * 工单状态
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
     * 工单状态集合，支持多选
     */
    private List<Integer> workOrderStatuses;
    
    /**
     * 处理人ID
     */
    private List<String> handleUserIds;
    
    /**
     * 完成开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date finishStartTime;
    
    /**
     * 完成结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date finishEndTime;
    
    /**
     * 取消开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date cancelStartTime;
    
    /**
     * 取消结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date cancelEndTime;
    
    /**
     * 动态查询参数
     * 格式：Q_F_VINCODE_S_EQ的意思：
     * Q_：代表查询。
     * _S：代表字符串。
     * _EQ：代表等于。
     * F_VINCODE：代表数据字段名称。
     *
     * 查询条件： EQ 等于；LK 模糊查询； IN 批量查询(如果类型是IN，则值为ArrayList)；
     * GT 大于；LT 小于；GTE 大于等于；LTE 小于等于；
     * 字段类型：S 字符串；N 数值；D 时间；
     */
    private Map<String, Object> dynamicParams;

    /**
     * 默认查询参数，指定查询字段，通过sql组装来定义
     */

    private Map<String, Object> defaultParams;

    /**
     * 是否需要数据权限：是，则用当前用户关联的城市去查询
     */
    private Boolean isNeedDataPermission = false;

}