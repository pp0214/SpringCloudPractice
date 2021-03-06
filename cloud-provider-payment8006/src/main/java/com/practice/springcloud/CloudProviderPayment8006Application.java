package com.practice.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author tyy
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudProviderPayment8006Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudProviderPayment8006Application.class, args);
    }

}
