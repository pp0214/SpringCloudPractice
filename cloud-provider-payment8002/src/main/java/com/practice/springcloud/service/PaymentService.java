package com.practice.springcloud.service;

import com.practice.springcloud.entities.Payment;

/**
 * @author tyy
 */
public interface PaymentService {
    int create(Payment payment);

    Payment getPaymentById(Long id);
}
