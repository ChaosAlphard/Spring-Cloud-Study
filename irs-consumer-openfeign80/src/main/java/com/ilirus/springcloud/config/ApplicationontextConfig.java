package com.ilirus.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;

@Configuration
public class ApplicationontextConfig {

    @Bean
    @LoadBalanced  // 授予restTemplate负载均衡能力
    public RestTemplate getRestTemplate() {
        String time = new SimpleDateFormat("HH:mm:ss").format(new Date());
        System.out.println(time+": RestTemplate被初始化了");
        return new RestTemplate();
    }

    @Bean
    public IRule LBRule() {
        System.out.println("Rule 被初始化了");
        // 定义负载均衡算法为随机
        return new RandomRule();
    }
}
