package com.dst.station.common;

import cn.hutool.core.text.StrFormatter;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.MD5;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dxx
 * @description 思倍云系统对接加签工具类
 * @since 2024年6月24日10:07:49
 */
@Slf4j
public class SpaceSignUtil {

    private final static String BODY_SIGN_FORMAT = "_appId={appId}&_appSecret={appSecret}&_time={appTime}&_body={appBody}";


    /**
     * 接口签名计算方法
     *
     * @param appKey    appid
     * @param appSecret
     * @param jsonBody  参数
     * @return
     */
    public static SpaceSign getSignStr(String appKey, String appSecret, String jsonBody) {
        long curTime = System.currentTimeMillis();
        Map<String, String> signParams = new HashMap<>();
        signParams.put("appId", appKey);
        signParams.put("appSecret", appSecret);
        signParams.put("appTime", curTime + "");
        signParams.put("appBody", MD5.create().digestHex(StrUtil.removeAllLineBreaks(jsonBody)));
        String waitSignVal = StrFormatter.format(BODY_SIGN_FORMAT, signParams, true);
        String signVal = MD5.create().digestHex(waitSignVal);
        return SpaceSign.builder().time(curTime + "").signStr(signVal).build();
    }

}
