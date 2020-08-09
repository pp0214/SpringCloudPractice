package com.practice.springcloud.controller;

import com.practice.springcloud.entities.CommonResult;
import com.practice.springcloud.entities.Payment;
import com.practice.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author tyy
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    PaymentService paymentService;

    @PostMapping("/payment/create")
    public CommonResult<Integer> create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("****插入结果" + result);

        if (result > 0) {
            return new CommonResult<Integer>(200, "插入数据库成功", result);
        }else {
            return new CommonResult<Integer>(444, "插入数据库失败", null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("****查询结果" + payment);

        if (payment != null) {
            return new CommonResult<Payment>(200, "查询数据库成功撒", payment);
        }else {
            return new CommonResult<Payment>(444, "没有对应记录，id:" + id, null);
        }
    }
}
