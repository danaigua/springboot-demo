package com.hengyue.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class SampleController extends AbstractBaseController {

    @RequestMapping(value = "echo/(msg)", method = RequestMethod.DELETE)
    public String echo(@PathVariable("msg") String msg){
        return super.getMessage("welcome.url", msg);
    }

    @RequestMapping("login")
    public String login() throws Exception{
        return super.getMessage("welcome.url", "111");
    }
}
