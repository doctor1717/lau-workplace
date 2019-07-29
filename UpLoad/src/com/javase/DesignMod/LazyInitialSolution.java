package com.javase.DesignMod;

//每个类或接口都有自己对应的初始化锁
//懒加载的双重检查否定问题的解决方案,可将instance设为volatile,或利用多个线程对同一类加载时的竞争class对象的初始化锁
public class LazyInitialSolution {
    private static volatile Class instance;

    public static Class getInstance(){
        if(instance == null){
            synchronized (LazyInitialSolution.class){
                if(instance == null){
                    instance = String.class;
                }
            }
        }
        return instance;
    }
}


