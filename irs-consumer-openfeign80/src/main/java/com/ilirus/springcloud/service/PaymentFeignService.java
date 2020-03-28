package com.ilirus.springcloud.service;

import com.ilirus.springcloud.entities.CommonResult;
import com.ilirus.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "irs-provider-payment")
public interface PaymentFeignService {
    @GetMapping("/payment/query/{id}")
    public CommonResult<Payment> getPaymentByID(@PathVariable("id") Long id);
}
