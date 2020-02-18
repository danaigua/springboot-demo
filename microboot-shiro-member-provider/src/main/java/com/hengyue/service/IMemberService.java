package com.hengyue.service;

import com.hengyue.entity.Member;

import java.util.Map;
import java.util.Set;

public interface IMemberService {

    public Member get(String mid);

    public Map<String, Set<String>> listAuthByMember(String mid);
}
