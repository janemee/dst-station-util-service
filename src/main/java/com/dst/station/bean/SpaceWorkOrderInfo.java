package com.dst.station.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpaceWorkOrderInfo implements Serializable {

    private String orderCode;

    /**
     * 父级工单编码：当该工单是子流程生成的，则有
     */
    private String parentOrderCode;

    private String createTime;

    private String status;

    private String statusCode;

    //1-待受理，2-处理中，3-已完成，4-已取消
    private Integer processState;

    private String orderFrom;

    private String creatorUser;
    private String creatorPersonCode;

    private List<SpacePersonInfo> handlerInfo;

    private Map<String, Object> data;

    private String instId;
    private String taskId;

    private String finishTime;

    private String cancelTime;

    private String orderTypeId;

    private String typeName;
    private String typeCode;

    private String pkId;

    private String layout;
    private String extInfo;

    public String getHandlers() {
        if (CollectionUtils.isNotEmpty(handlerInfo)) {
            return handlerInfo.stream().map(e -> e.getUserName()).collect(Collectors.joining(","));
        }
        return "";
    }
}
