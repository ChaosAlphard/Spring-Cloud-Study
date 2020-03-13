package com.ilirus.springcloud;

import com.ilirus.springcloud.entities.Payment;
import com.ilirus.springcloud.service.PaymentService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.time.Duration;

@SpringBootTest
class PaymentMain8001Test {
    @Resource
    PaymentService paymentService;

    @BeforeEach
    void echo() {
        System.out.println("====Test Start====");
    }

    @AfterAll
    static void done() {
        System.out.println("====Test Done.====");
    }

    @Test
    void checkQuery() {
        Payment payment = paymentService.getPaymentByID(1L);
        Assertions.assertNotNull(payment);
    }

    @Test
    @Transactional
    @Rollback
    void checkCreate() throws SQLException {
        Payment payment = new Payment();
        payment.setSerial("test");
        int res = paymentService.createPayment(payment);
        System.out.println(res);
        Assertions.assertNotEquals(res, 0);

        Assertions.assertThrows(SQLException.class, () -> {
            /* ... */
        });
        Assertions.assertTimeout(Duration.ofSeconds(3), () -> {
            System.out.println("超时");
        });
    }
}
