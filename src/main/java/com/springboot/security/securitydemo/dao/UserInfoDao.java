package com.springboot.security.securitydemo.dao;

import com.springboot.security.securitydemo.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author liluo
 * @create 2022/5/30 19:38
 */
public interface UserInfoDao extends JpaRepository<UserInfo,Long> {
    UserInfo findByUsername(String username);
}
