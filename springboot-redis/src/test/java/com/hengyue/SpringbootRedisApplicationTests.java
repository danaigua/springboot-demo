package com.hengyue;

import com.hengyue.util.redis.RedisUtils;
import entity.Person;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

@SpringBootTest
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
class SpringbootRedisApplicationTests {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisUtils redisUtils;

    @Test
    void contextLoads() {
    }
    @Test
    public void testRedis(){
        stringRedisTemplate.opsForValue().set("name", "job");
        System.out.println(stringRedisTemplate.opsForValue().get("name"));
    }

    @Test
    public void test(){
        Person person = new Person();
        person.setAge(23);
        person.setId("001");
        person.setName("Zhangsan");
        redisUtils.set("person-001", person);
        System.out.println(redisUtils.get("person-001"));
    }

}
