package com.offcn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients//开启feign的功能
@EnableCircuitBreaker//开启熔断保护功能
@EnableHystrixDashboard//开启可视化
public class ConsumerUserFeignStart {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerUserFeignStart.class, args);
    }
}
