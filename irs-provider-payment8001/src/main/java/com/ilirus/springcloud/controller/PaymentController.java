package com.ilirus.springcloud.controller;

import com.ilirus.springcloud.entities.CommonResult;
import com.ilirus.springcloud.entities.Payment;
import com.ilirus.springcloud.enums.Status;
import com.ilirus.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment) {
        int res = paymentService.createPayment(payment);
        log.info("插入结果: "+res);

        if(res > 0) {
            return CommonResult.Of(Status.SUCCESS);
        } else {
            return CommonResult.Of(Status.FAIL);
        }
    }

    @GetMapping("/query/{id}")
    public CommonResult queryByID(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentByID(id);
        return CommonResult.OfData(Status.SUCCESS, payment);
    }
}
