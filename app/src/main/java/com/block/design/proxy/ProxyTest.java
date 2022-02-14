package com.block.design.proxy;

import java.lang.reflect.Proxy;

/**
 * 代理模式
 * (委托模式)
 */
class ProxyTest {

    private static void test() {
        ILawsuit xiaoMin = new XiaoMin();
        ILawsuit lawyer = new Lawyer(xiaoMin);
        lawyer.submit();
        lawyer.burden();
        lawyer.defend();
        lawyer.finish();
    }

    private static void dynamicTest() {
        ILawsuit xiaoMin = new XiaoMin();
        DynamicProxy proxy = new DynamicProxy(xiaoMin);
        ClassLoader loader = xiaoMin.getClass().getClassLoader();
        ILawsuit lawyer = (ILawsuit) Proxy.newProxyInstance(loader, new Class[]{ILawsuit.class}, proxy);
        lawyer.submit();
        lawyer.burden();
        lawyer.defend();
        lawyer.finish();
    }
}
