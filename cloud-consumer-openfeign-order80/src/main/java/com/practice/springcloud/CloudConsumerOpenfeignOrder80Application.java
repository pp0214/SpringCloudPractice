package com.practice.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author tyy
 */
@SpringBootApplication
@EnableFeignClients
public class CloudConsumerOpenfeignOrder80Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerOpenfeignOrder80Application.class, args);
    }

}
