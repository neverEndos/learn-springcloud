package com.endos.controller;

import com.endos.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Endos on 2017/4/8.
 */
@RestController
public class MovieController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/movie/{id}")
    public User findById(@PathVariable("id") Long id) {
        // "simple-provider-user"取自提供服务应用的spring.application.name
        return this.restTemplate.getForObject(
                "http://simple-provider-user/simple/" + id, User.class);
    }

    @GetMapping("/test")
    public String test(){
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("simple-provider-user");
        System.out.println("111:" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + ":" + serviceInstance.getServiceId());

        ServiceInstance serviceInstance2 = this.loadBalancerClient.choose("simple-provider-user2");
        System.out.println("222:" + serviceInstance2.getHost() + ":" + serviceInstance2.getPort() + ":" + serviceInstance2.getServiceId());

        return "1";
    }
}
