package com.practice.springcloud.lb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author tyy
 */
@Component
@Slf4j
public class MyLoadBalancer implements LoadBalancer{
    private AtomicInteger integer = new AtomicInteger();

    private int getAndIncrement() {
        for (;;) {
            int curr = integer.get();
            int next = curr >= Integer.MAX_VALUE ? 0 : curr + 1;
            if (integer.compareAndSet(curr, next)) {
                log.info("访问次数:" + next);
                return next;
            }
        }
    }
    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstancesList) {
        return serviceInstancesList.get(getAndIncrement() % serviceInstancesList.size());
    }
}
