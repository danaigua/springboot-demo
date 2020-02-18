package com.hengyue.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "我的第一个swagger2模块控制器")
@RestController
public class MySwaggerTestController {

    @ApiOperation(value = "第一个测试用的swagger接口", notes = "没啥好传的，就随便说说")
    @ApiImplicitParam(name = "null", value = "没有啥", required = true, dataType = "null")
    @RequestMapping(value = "/swagger", method = RequestMethod.GET)
    public String swagger(){
        return null;
    }

}
