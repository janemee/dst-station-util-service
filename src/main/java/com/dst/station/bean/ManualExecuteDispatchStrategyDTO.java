package com.dst.station.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 * 手动执行派单策略请求DTO
 */
@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ManualExecuteDispatchStrategyDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 工单编码列表（必填）
     * 限制：最多100条
     */
    @NotEmpty(message = "工单编码列表不能为空")
    @Size(max = 100, message = "单次最多执行100条工单")
    private List<String> workOrderCodes;

    /**
     * 派单时间依据（必填）
     * 1: 按工单创建时间获取排班人员派单
     * 2: 按当前时间获取排班人员派单
     */
    @Min(value = 1, message = "派单时间依据值无效")
    @Max(value = 2, message = "派单时间依据值无效")
    private Integer timeBasis;

    /**
     * 操作来源标识（可选，用于日志记录）
     * 默认值：MANUAL_PC
     */
    private String operationSource;
}