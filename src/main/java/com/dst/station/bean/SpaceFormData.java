package com.dst.station.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.Map;

@Data
public class SpaceFormData {

    /**
     * 表单ID
     */
    private String formId;

    /**
     * 表单别名
     */
    private String alias;

    private String boAlias;

    /**
     * 表单标题
     */
    private String title;

    /**
     * 表单数据
     */
    private Map<String, Object> data;

    /**
     * 表单HTML代码
     */
    private String template;

    /**
     * 表单字段权限，对应表单数据
     */
    private Object permission;

    /**
     * 表单前端脚本
     */
    private String script;

    private String buttons;

    /**
     * 自定义事件内
     */
    private String metadata;

    /**
     *
     */
    private String opinionSetting;

    private Object entMap;

    private int wizard;

    private String appId;

    private String buttonUid;

    private String userCode;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * 轨迹ID
     */
    private String hisId;

    private String layout;

    private String extInfo;

    private String instId;
}
