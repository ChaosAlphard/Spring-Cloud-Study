package com.ilirus.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan("com.ilirus.springcloud.dao")
@EnableEurekaClient
@EnableDiscoveryClient
public class PaymentFeignMain8003 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentFeignMain8003.class);
    }
}
