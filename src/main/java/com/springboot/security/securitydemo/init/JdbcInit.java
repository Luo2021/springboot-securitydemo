package com.springboot.security.securitydemo.init;

import com.springboot.security.securitydemo.dao.UserInfoDao;
import com.springboot.security.securitydemo.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Author liluo
 * @create 2022/5/30 20:08
 */
//@Component
public class JdbcInit {
    @Autowired
    private UserInfoDao dao;

    //@PostConstruct
    public void init(){
        PasswordEncoder encode = new BCryptPasswordEncoder();
        UserInfo u = new UserInfo();
        u.setUsername("luoli");
        u.setPassword(encode.encode("123456"));
        u.setRole("admin");
        dao.save(u);

        u = new UserInfo();
        u.setUsername("lisi");
        u.setPassword(encode.encode("123456"));
        u.setRole("normal");
        dao.save(u);
    }
}
