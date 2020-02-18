package com.hengyue.service.impl;

import com.hengyue.dao.IActionDao;
import com.hengyue.dao.IMemberDao;
import com.hengyue.dao.IRoleDao;
import com.hengyue.service.IMemberService;
import com.hengyue.entity.Member;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class MemberServiceImpl implements IMemberService {

    @Resource
    private IMemberDao memberDao;
    @Resource
    private IRoleDao roleDao;
    @Resource
    private IActionDao actionDao;


    @Override
    public Member get(String mid) {
        return this.memberDao.findById(mid);
    }

    @Override
    public Map<String, Set<String>> listAuthByMember(String mid) {
        Map<String, Set<String>> map = new HashMap<String, Set<String>>();
        map.put("allRoles", this.roleDao.findAllRoleByMember(mid));
        map.put("allActions", this.actionDao.findAllActionByMember(mid));
        return map;
    }
}
