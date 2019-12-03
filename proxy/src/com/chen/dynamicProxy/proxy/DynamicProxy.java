package com.chen.dynamicProxy.proxy;

import com.chen.dynamicProxy.service.UserService;
import com.chen.dynamicProxy.service.impl.UserServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler {

    private Object target;
    public DynamicProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        System.out.println("调用开始处理");
        result = method.invoke(target, args);
        System.out.println("调用结束处理");
        return result;
    }

    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        DynamicProxy dynamicProxy = new DynamicProxy(userService);
        ClassLoader classLoader = userService.getClass().getClassLoader();
        Class<?>[] interfaces = userService.getClass().getInterfaces();
        UserService proxyInstance = (UserService) Proxy.newProxyInstance(classLoader, interfaces, dynamicProxy);
        proxyInstance.addUser();

    }
}
