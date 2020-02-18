package com.hengyue;

import com.hengyue.service.IMemberService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class TestMemberService {

    @Resource
    private IMemberService memberService;

    @Test
    public void testGet(){
        System.out.println(this.memberService.get("1234"));
    }
    @Test
    public void testAuth(){
        System.out.println(this.memberService.listAuthByMember("1234"));
    }

}
