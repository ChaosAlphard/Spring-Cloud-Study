package com.ilirus.springcloud.controller;

import com.ilirus.springcloud.entities.CommonResult;
import com.ilirus.springcloud.entities.Payment;
import com.ilirus.springcloud.enums.Status;
import com.ilirus.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/consumer")
@Slf4j
public class OrderController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/payment/query/{id}")
    public CommonResult query(@PathVariable("id") Long id) {
        return paymentFeignService.getPaymentByID(id);
    }
}
