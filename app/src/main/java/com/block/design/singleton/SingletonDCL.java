package com.block.design.singleton;

/**
 * Double Checked Locking
 * 1.线程安全
 * 2.懒加载
 */
public class SingletonDCL {

    /**
     * 为什么要加 volatile
     * new SingletonDCL() 不是原子操作
     * 1.给 mInstance 分配内存
     * 2.调用 SingleTon 的构造方法初始化成员变量
     * 3.将 mInstance 指向分配的内存空间（在这一步 mInstance 已经不为 null 了）
     * JVM 会有指令重排 正常是123，可能变成132.
     * 当 线程A 执行到132的第3步时，暂停了，线程B调用getInstance的时候，判断已经不为null，直接返回 mInstance
     * 这时候就会报空指针。
     */
    private static volatile SingletonDCL mInstance;

    private SingletonDCL() {

    }

    public static SingletonDCL getInstance() {
        if (mInstance == null) {
            synchronized (SingletonDCL.class) {
                if (mInstance == null) {
                    mInstance = new SingletonDCL();
                }
            }
        }
        return mInstance;
    }

    public void info(){

    }

}
