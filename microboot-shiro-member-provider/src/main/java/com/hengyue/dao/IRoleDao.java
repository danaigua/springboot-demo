package com.hengyue.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.Set;

@Mapper
public interface IRoleDao {

    public Set<String> findAllRoleByMember(String mid);
}
