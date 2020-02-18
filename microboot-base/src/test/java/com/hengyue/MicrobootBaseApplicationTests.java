package com.hengyue;

import com.hengyue.controller.SampleController;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

@SpringBootTest(classes = SampleController.class)
//@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
class MicrobootBaseApplicationTests {

    @Resource
    private SampleController sampleController;

    @Test
    public void testLogin() throws Exception{
        /*TestCase.assertEquals(this.sampleController.login(), " ");*/
       /* System.out.println(this.sampleController.login());*/
    }

    @Test
    void contextLoads() {
    }



}
