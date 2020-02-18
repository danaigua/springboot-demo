package com.hengyue.controller;

import com.hengyue.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(){
        return userService.listAll().toString();
    }
}
