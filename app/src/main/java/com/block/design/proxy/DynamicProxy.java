package com.block.design.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

class DynamicProxy implements InvocationHandler {
    /**
     * 被代理的类引用
     */
    private Object obj;

    public DynamicProxy(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(obj, args);
        return result;
    }
}
