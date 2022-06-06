package com.springboot.security.securitydemo.service;

import com.springboot.security.securitydemo.entity.UserInfo;

/**
 * @Author liluo
 * @create 2022/5/30 19:42
 */
public interface UserInfoService {
    UserInfo findUserInfo(String username);
}
