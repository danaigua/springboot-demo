package com.hengyue.controller;

import com.hengyue.service.IMemberService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/member")
public class MemberController {
    @Resource
    private IMemberService memberService;

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public Object get(String mid){
        return this.memberService.get(mid);
    }

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public Object auth(String mid){
        return this.memberService.listAuthByMember(mid);
    }

}
