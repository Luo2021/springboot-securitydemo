package com.springboot.security.securitydemo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author liluo
 * @create 2022/5/30 17:23
 */
@RestController
@RequestMapping("/hello")
public class HelloSecurityController {

    @RequestMapping("/world")
    public String sayHello(){
        return "Hello Spring Security 安全管理框架！";
    }

    @RequestMapping("/helloUser")
    @PreAuthorize(value = "hasAnyRole('normal')")
    public String helloCommonUser(){
        return "Hello 拥有normal角色用户！";
    }

    @RequestMapping("/helloAdmin")
    @PreAuthorize("hasAnyRole('admin')")
    public String helloAdmin(){
        return "Hello 拥有admin角色用户！";
    }

}
