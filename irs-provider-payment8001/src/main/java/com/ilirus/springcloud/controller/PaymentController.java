package com.ilirus.springcloud.controller;

import com.ilirus.springcloud.entities.CommonResult;
import com.ilirus.springcloud.entities.Payment;
import com.ilirus.springcloud.enums.Status;
import com.ilirus.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment) {
        int res = paymentService.createPayment(payment);
        log.info("插入结果: "+res);

        if(res > 0) {
            return CommonResult.of(Status.SUCCESS);
        } else {
            return CommonResult.of(Status.FAIL);
        }
    }

    @GetMapping("/query/{id}")
    public CommonResult queryByID(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentByID(id);
        return CommonResult.ofCustom(Status.SUCCESS, "[端口"+port+"]成功", payment);
    }
}
