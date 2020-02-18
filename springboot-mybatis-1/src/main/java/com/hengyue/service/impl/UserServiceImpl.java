package com.hengyue.service.impl;

import com.hengyue.dao.UserDao;
import com.hengyue.entity.User;
import com.hengyue.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;


    @Override
    public List<User> listAll() {
        return userDao.listAll();
    }
}
