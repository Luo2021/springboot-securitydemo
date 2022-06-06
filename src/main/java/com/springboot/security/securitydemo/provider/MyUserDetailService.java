package com.springboot.security.securitydemo.provider;

import com.springboot.security.securitydemo.dao.UserInfoDao;
import com.springboot.security.securitydemo.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author liluo
 * @create 2022/5/30 20:27
 */
@Component("MyUserDetailService")
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private UserInfoDao dao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = null;
        UserInfo userInfo = null;
        if(username != null){
            userInfo = dao.findByUsername(username);
            if(userInfo != null){
                List<GrantedAuthority> list = new ArrayList<>();
                GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_"+userInfo.getRole());
                list.add(authority);
                user = new User(userInfo.getUsername(),userInfo.getPassword(),list);
            }
        }
        return user;
    }
}
