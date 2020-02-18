package com.hengyue.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Arithmetic {

    @RequestMapping(value = "/division", method = RequestMethod.GET)
    public double division(){
        return 10/0;
    }
}
