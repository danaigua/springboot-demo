package com.hengyue;

import com.hengyue.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

@SpringBootTest(classes = TestUserDao.class)
@WebAppConfiguration
public class TestUserDao {
    @Autowired
    private UserDao userDao;
    @Test
    public void list(){
        System.out.println(userDao.listAll());
    }

}
