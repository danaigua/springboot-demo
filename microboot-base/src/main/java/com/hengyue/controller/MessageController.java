package com.hengyue.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MessageController {

    @RequestMapping(value = "/showStyle", method = RequestMethod.GET)
    public String showStyle(Model model){
        model.addAttribute("url", "www.hengyue.com");
        return "message/message_show";
    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String show(String mid, Model model){
        model.addAttribute("url", "www.hengyue.com");
        model.addAttribute("mid", mid);
        return "message/message_show";
    }
}
