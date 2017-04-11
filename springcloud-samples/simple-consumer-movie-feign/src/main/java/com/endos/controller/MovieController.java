package com.endos.controller;

import com.endos.feign.UserFeignClient;
import com.endos.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Endos on 2017/4/8.
 */
@RestController
public class MovieController {

    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/movie/{id}")
    public User findById(@PathVariable("id") Long id) {
        return this.userFeignClient.findById(id);
    }

    @GetMapping("/test")
    public User testPost(User user){
        return this.userFeignClient.postUser(user);
    }
}
