package com.practice.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author tyy
 */
@RestController
@Slf4j
public class OrderController {

    private static final String URL = "http://cloud-provider-name";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/zk")
    public String getZookeeperMsg() {
        return restTemplate.getForObject(URL + "/payment/zk", String.class);
    }
}
