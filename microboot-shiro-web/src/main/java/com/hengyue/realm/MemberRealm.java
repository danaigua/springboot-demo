package com.hengyue.realm;

import com.hengyue.entity.Member;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MemberRealm extends AuthorizingRealm {

    @Resource
    private RestTemplate restTemplate;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo auth = new SimpleAuthorizationInfo();
        String mid = (String) principalCollection.getPrimaryPrincipal(); /*获取用户名*/
        String url = "http://localhost:8001/member/auth?mid=" + mid;
        Map<String, Set<String>> map = this.restTemplate.postForObject(url, null, Map.class);

        Set<String> allRoles = new HashSet<>();
        Set<String> allActions = new HashSet<>();
        allRoles.addAll((List<String>) map.get("allRoles"));
        allActions.addAll((List<String>) map.get("allActions"));
        auth.setRoles(allRoles);
        auth.setStringPermissions(allActions);
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {


        System.out.println("开始认证");
        String mid = token.getPrincipal().toString();
        String url = "http://localhost:8001/member/get" + mid;
        Member member = restTemplate.postForObject(url, null, Member.class);
        if(member == null) {
            throw  new UnknownAccountException("用户不存在");
        }
        //验证密码
        String password = "";
        //其他锁的验证
        SimpleAuthenticationInfo auth = new SimpleAuthenticationInfo(token.getPrincipal(), password, "xxx");
        return auth;
    }
}
