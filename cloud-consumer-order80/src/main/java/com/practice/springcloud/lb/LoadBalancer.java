package com.practice.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author tyy
 */
public interface LoadBalancer {
    /**
     * 从已有的服务中选出一个，作为下次请求的对象
     * @param serviceInstancesList 服务列表
     * @return the next Service Instance.
     */
    ServiceInstance instance(List<ServiceInstance> serviceInstancesList);
}
