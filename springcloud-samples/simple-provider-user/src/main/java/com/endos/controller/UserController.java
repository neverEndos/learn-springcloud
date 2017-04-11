package com.endos.controller;

import com.endos.entity.User;
import com.endos.repository.UserRepository;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Endos on 2017/4/8.
 */
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EurekaClient discoveryClient;

    @GetMapping("/simple/{id}")
    public User findById(@PathVariable("id") Long id){
        return this.userRepository.findOne(id);
    }

    @GetMapping("/eureka-instance")
    public String serviceUrl() {
        InstanceInfo instance = discoveryClient.getNextServerFromEureka("SIMPLE-PROVIDER-USER", false);
        return instance.getHomePageUrl();
    }

    @PostMapping("/user")
    public User postUser(@RequestBody User user){
        return user;
    }

}
