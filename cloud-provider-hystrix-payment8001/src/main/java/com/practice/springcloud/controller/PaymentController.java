package com.practice.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.practice.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author tyy
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @GetMapping("/payment/ok/{id}")
    public String paymentOk(@PathVariable("id") Integer id) {
        return paymentService.paymentInfoOk(id);
    }

    @GetMapping("/payment/timeout/{id}")
    public String paymentTimeout(@PathVariable("id")Integer id) {
        return paymentService.paymentInfoTimeout(id);
    }

    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id")Integer id) {
        return paymentService.paymentInfoTimeout(id);
    }
}
