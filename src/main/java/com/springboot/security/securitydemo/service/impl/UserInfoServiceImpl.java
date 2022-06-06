package com.springboot.security.securitydemo.service.impl;

import com.springboot.security.securitydemo.dao.UserInfoDao;
import com.springboot.security.securitydemo.entity.UserInfo;
import com.springboot.security.securitydemo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author liluo
 * @create 2022/5/30 19:43
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoDao dao;
    @Override
    public UserInfo findUserInfo(String username) {
        UserInfo userInfo = dao.findByUsername(username);
        return userInfo;
    }
}
