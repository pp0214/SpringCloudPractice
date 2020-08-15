package com.practice.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author tyy
 */
@Configuration
public class MyRule {

    @Bean
    public IRule mySelfRule() {
        return new RandomRule();
    }
}
