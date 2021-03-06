package com.ilirus.springcloud.service.impl;

import com.ilirus.springcloud.dao.PaymentDao;
import com.ilirus.springcloud.entities.Payment;
import com.ilirus.springcloud.exception.custom.NoThatEntityException;
import com.ilirus.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    @Override
    public Payment getPaymentByID(Long id) {
        return paymentDao.getPaymentByID(id).orElseThrow(NoThatEntityException::new);
    }

    @Override
    public int createPayment(Payment payment) {
        return paymentDao.createPayment(payment);
    }
}
