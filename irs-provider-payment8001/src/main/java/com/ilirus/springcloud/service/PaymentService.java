package com.ilirus.springcloud.service;

import com.ilirus.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    public Payment getPaymentByID(@Param("id") Long id);

    public int createPayment(Payment payment);
}
