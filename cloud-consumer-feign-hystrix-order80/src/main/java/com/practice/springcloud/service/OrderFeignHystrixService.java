package com.practice.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author tyy
 */
@Component
@FeignClient(value = "CLOUD-HYSTRIX-PAYMENT8001", fallback = OrderFeignHystrixServiceImpl.class)
public interface OrderFeignHystrixService {
    @GetMapping("/payment/ok/{id}")
    String paymentOk(@PathVariable("id") Integer id);

    @GetMapping("/payment/timeout/{id}")
    String paymentTimeout(@PathVariable("id")Integer id);

}
