package com.dst.station.bean;

import lombok.Data;

/**
 * 工单池数据重试包装类
 * INIT_DATA_POOL 和 DATA_POOL_CREATE 两个场景共用
 *
 * @author Generated
 */
@Data
public class DataPoolRetryData {

    /**
     * 工单池数据DO
     */
    private DataPoolDataDO dataPoolDataDO;

    /**
     * 工单池表名
     */
    private String tableName;
}
