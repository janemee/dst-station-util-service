package com.dst.station.service;

import com.dst.station.common.HttpUtils;

import java.util.HashMap;

public class OrchEndpointService {


    /**
     * 获取请求全路径
     *
     * @param env 环境
     * @param url 请求路径
     * @return 请求全路径
     */
    public static String getInstance(String env, String url) {
        String url_header = "https://api.dev.dstzc.com/orch-endpoint/auth/v1/workflow/start";
        if ("pre".equals(env)) {
            url_header = "https://api.pre.dstzc.com/orch-endpoint/auth/v1/workflow/start";
        } else if ("test".equals(env)) {
            url_header = "https://api.test.dstzc.com/orch-endpoint/auth/v1/workflow/start";
        } else if ("prod".equals(env)) {
            url_header = "https://api.dstzc.com/orch-endpoint/auth/v1/workflow/start";
        } else if ("uat".equals(env)) {
            url_header = "https://api.uat.dstzc.com/orch-endpoint/auth/v1/workflow/start";
        }
        return String.format("%s%s", url_header, url);
    }

    /**
     * 启动流程
     *
     * @param env
     * @param token
     * @param params
     * @return
     */
    public static String startDoPost(String env, String token, String name, Object params) {
        String url = getInstance(env, "");
        HashMap<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("name", name);
        paramsMap.put("executeParam", params);
        return HttpUtils.doPost(url, token, paramsMap);
    }

}
