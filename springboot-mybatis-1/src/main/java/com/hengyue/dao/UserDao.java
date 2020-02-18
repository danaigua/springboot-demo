package com.hengyue.dao;

import com.hengyue.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 用户持久层接口
 */
@Mapper
public interface UserDao {
    /**
     * 查询所有的用户
     * @return
     */
    public List<User> listAll();

}
