package com.ilirus.springcloud.dao;

import com.ilirus.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

public interface PaymentDao {
    public Optional<Payment> getPaymentByID(@Param("id") Long id);

    public int createPayment(Payment payment);
}
