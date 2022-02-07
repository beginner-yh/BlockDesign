package com.block.design.singleton;

/**
 * 内部类
 * 1.懒加载
 * 2.线程安全
 */
public class SingletonInnerClass {

    private SingletonInnerClass() {

    }

    public static SingletonInnerClass getInstance() {
        return Singleton.mInstance;
    }

    public void info() {

    }

    /**
     * 外部类的加载不会导致内部类立即加载，实现了延迟初始化
     * 类只会被加载一次，保证了线程安全
     */
    public static class Singleton {
        private static final SingletonInnerClass mInstance = new SingletonInnerClass();
    }
}
