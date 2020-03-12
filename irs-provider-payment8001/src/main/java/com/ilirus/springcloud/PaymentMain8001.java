package com.ilirus.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ilirus.springcloud.dao")
public class PaymentMain8001 {
    public static void Main(String[] args) {
        SpringApplication.run(PaymentMain8001.class);
    }
}
