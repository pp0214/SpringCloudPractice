package com.practice.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author tyy
 */
@Component
public class OrderFeignHystrixServiceImpl implements OrderFeignHystrixService {
    @Override
    public String paymentOk(Integer id) {
        return "------OrderFeignHystrixService paymentOk";
    }

    @Override
    public String paymentTimeout(Integer id) {
        return "------OrderFeignHystrixService paymentTimeout";
    }
}
