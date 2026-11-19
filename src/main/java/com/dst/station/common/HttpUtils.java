package com.dst.station.common;

import cn.hutool.json.JSONUtil;
import com.dst.steed.common.util.DstJsonUtil;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class HttpUtils {

    private static final OkHttpClient CLIENT = new OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(100, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build();

    public static String doGet(String url, String token) {
        Request request = new Request.Builder()
                .headers(new Headers.Builder().add("token", token).build())
                .url(url)
                .build();
        String result = "";
        try {
            Response response = CLIENT.newCall(request).execute();
            result = Objects.requireNonNull(response.body()).string();
        } catch (Exception e) {
            log.error("请求异常：{}", e.getMessage(), e);
        }
        return result;
    }

    public static String doPost(String url, String token, Object params) {
        MediaType JSON = MediaType.get("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(JSONUtil.toJsonStr(params), JSON);
        Request request = new Request.Builder()
                .headers(new Headers.Builder().add("token", token).build())
                .addHeader("Content-Type", "application/json")
                .post(body)
                .url(url)
                .build();
        String result = "";
        try {
            Response response = CLIENT.newCall(request).execute();
            result = Objects.requireNonNull(response.body()).source().readUtf8();
            log.debug("请求参数：{}", DstJsonUtil.toString(params));
            log.debug("请求结果：{}", result);
        } catch (Exception e) {
            log.error("请求异常：{}", e.getMessage(), e);
        }
        return result;
    }


    public static String doPost(String url, Headers headerMap,Object params) {
        MediaType JSON = MediaType.get("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(JSONUtil.toJsonStr(params), JSON);
        Request request = new Request.Builder()
                .headers(headerMap)
                .addHeader("Content-Type", "application/json")
                .post(body)
                .url(url)
                .build();
        String result = "";
        try {
            Response response = CLIENT.newCall(request).execute();
            result = Objects.requireNonNull(response.body()).source().readUtf8();
            log.debug("请求头：{}", DstJsonUtil.toString(headerMap));
            log.debug("请求参数：{}", DstJsonUtil.toString(params));
            log.debug("请求结果：{}", result);
        } catch (Exception e) {
            log.error("请求异常：{}", e.getMessage(), e);
        }
        return result;
    }

}
