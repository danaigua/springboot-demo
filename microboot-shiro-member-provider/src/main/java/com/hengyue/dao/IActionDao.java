package com.hengyue.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.Set;

@Mapper
public interface IActionDao {
    public Set<String> findAllActionByMember(String mid);
}
