package com.hengyue.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {

    @RequestMapping(value = "/addPage", method = RequestMethod.GET)
    public String addPage(){
        return "member_add";
    }

}
