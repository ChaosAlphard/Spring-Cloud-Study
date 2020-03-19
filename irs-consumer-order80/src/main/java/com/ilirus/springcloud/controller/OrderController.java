package com.ilirus.springcloud.controller;

import com.ilirus.springcloud.entities.CommonResult;
import com.ilirus.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/consumer")
@Slf4j
public class OrderController {
    // private static final String PAYMENT_URL = "http://localhost:8001/payment";
    private static final String PAYMENT_URL = "http://irs-provider-payment/payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/payment/create")
    public CommonResult create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL+"/create", payment, CommonResult.class);
    }

    @GetMapping("/payment/query/{id}")
    public CommonResult query(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL+"/query/"+id, CommonResult.class);
    }
}
