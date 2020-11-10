package com.birdsnail.springboot.customconfig.controller;

import com.birdsnail.springboot.customconfig.pojo.UserInfo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : BirdSnail
 * @Date : 2020/11/10
 */
@RestController
public class UserController {

    private final UserInfo user;

    @Autowired
    public UserController(UserInfo user) {
        this.user = user;
    }

    @GetMapping("/hello/user")
    public String getUserInfo() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(user);
    }
}
