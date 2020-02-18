package com.hengyue;

import com.hengyue.entity.Member;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class TestMemberController {

    private RestTemplate restTemplate = new RestTemplate();

    @Test
    public void testGet(){
        String url = "http://localhost:8001/member/get?mid=1234";
        Member vo = this.restTemplate.postForObject(url, null, Member.class);
        System.out.println(vo);
    }


}
