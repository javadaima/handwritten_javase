package com.chen.dynamicProxy.service.impl;

import com.chen.dynamicProxy.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public void addUser() {
        System.out.println("正在添加用户..........");
    }
}
