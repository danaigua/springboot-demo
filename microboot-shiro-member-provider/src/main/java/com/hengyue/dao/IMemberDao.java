package com.hengyue.dao;

import com.hengyue.entity.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IMemberDao {

    public Member findById(String mid);
}
