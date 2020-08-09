package com.practice.springcloud.service;

import com.practice.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author tyy
 */
public interface PaymentService {
    int create(Payment payment);

    Payment getPaymentById(Long id);
}
