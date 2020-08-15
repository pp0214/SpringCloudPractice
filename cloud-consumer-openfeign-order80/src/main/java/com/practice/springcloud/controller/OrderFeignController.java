package com.practice.springcloud.controller;

import com.practice.springcloud.entities.CommonResult;
import com.practice.springcloud.entities.Payment;
import com.practice.springcloud.service.OrderFeignService;
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
public class OrderFeignController {

    @Resource
    private OrderFeignService orderFeignService;

    @GetMapping("/consumer/payment/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return orderFeignService.getPaymentById(id);
    }

    @GetMapping("/consumer/payment/timeout")
    public String timeout() {
        return orderFeignService.timeout();
    }
}
