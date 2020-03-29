package com.ilirus.springcloud.controller;

import com.ilirus.springcloud.entities.CommonResult;
import com.ilirus.springcloud.entities.Payment;
import com.ilirus.springcloud.enums.Status;
import com.ilirus.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {
    @Resource
    private DiscoveryClient discoveryClient;

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

    @GetMapping("/discovery")
    public CommonResult discovery() {
        List<String> services = discoveryClient.getServices();
        return CommonResult.ofData(Status.SUCCESS, services);
    }

    @GetMapping("/discovery/{instances}")
    public CommonResult discovery(@PathVariable String instances) {
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances(instances);
        return CommonResult.ofData(Status.SUCCESS, serviceInstances);
    }

    @GetMapping("/timeout")
    public CommonResult timeout() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3L);
        return CommonResult.ofCustom(Status.FAIL, "超时", port);
    }
}
