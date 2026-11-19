package com.dst;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = "com.dst")
public class DstStationUtilServiceApplication {
    public static void main(String[] args) {
        System.out.println("✅ [DEBUG] Main method started. About to run SpringApplication...");
        try {
            SpringApplication.run(DstStationUtilServiceApplication.class, args);
            System.out.println("✅ [DEBUG] SpringApplication.run() completed.");
        } catch (Exception e) {
            System.err.println("❌ [ERROR] Application failed to start: 热部署重新启动，不影响服务，错误信息：" + e.getMessage());
        }
    }
}