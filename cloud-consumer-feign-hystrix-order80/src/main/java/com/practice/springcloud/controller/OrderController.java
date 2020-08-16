package com.practice.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.practice.springcloud.service.OrderFeignHystrixService;
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
@DefaultProperties(defaultFallback = "globalFallBack")
public class OrderController {
    @Resource
    private OrderFeignHystrixService orderFeignHystrixService;

    @GetMapping("/consumer/payment/ok/{id}")
    public String testOk(@PathVariable("id")Integer id) {
        return orderFeignHystrixService.paymentOk(id);
    }

    @GetMapping("/consumer/payment/timeout/{id}")
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
    })
    public String testTimeout(@PathVariable("id")Integer id) {
        return orderFeignHystrixService.paymentTimeout(id);
    }

    public String paymentInfoTimeoutMethod(@PathVariable("id")Integer id) {
        return "80线程池: " + Thread.currentThread().getName() + "PaymentInfoTimeout, Id: " + id + " 请求失败了";
    }

    public String globalFallBack() {
        return "Global Call Back Function!";
    }

}
