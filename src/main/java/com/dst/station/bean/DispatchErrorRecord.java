package com.dst.station.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/**
 * 派单异常记录实体
 *
 * @author Generated
 */
@Data
@Document(collection = "dispatch_error_record")
public class DispatchErrorRecord {

    /**
     * MongoDB _id
     */
    private String id;

    /**
     * 追踪ID，关联同一次操作
     */
    private String traceId;

    /**
     * 工单类型编码
     */
    private String typeCode;

    /**
     * 工单编码（可为空）
     */
    private String workOrderCode;

    /**
     * 业务工单编码（可为空）
     */
    private String businessOrderCode;

    /**
     * 工单池表名（池相关异常时填充）
     */
    private String dataPoolTableName;

    /**
     * 异常场景枚举
     */
    private String errorScene;

    /**
     * 异常类型枚举
     */
    private String errorType;

    /**
     * 异常消息
     */
    private String errorMessage;

    /**
     * 原始数据JSON（用于重试）
     */
    private String originalData;

    /**
     * 原始数据类名（用于反序列化）
     */
    private String originalDataClass;

    /**
     * 已重试次数
     */
    private Integer retryCount;

    /**
     * 最大重试次数（默认3）
     */
    private Integer maxRetryCount;

    /**
     * 重试状态：PENDING / SUCCESS / FAILED / EXHAUSTED
     */
    private String retryStatus;

    /**
     * 异常时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime errorTime;

    /**
     * 最后重试时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime lastRetryTime;
}
