package com.javase.DesignMod;

public class Singleton {
    private  Singleton(){ };
    private static volatile Singleton instance = null;


    public static Singleton getInstance(){
        if(instance == null){
            synchronized (Singleton.class){
                if(instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
class LazySingle{
    private LazySingle(){};

    private static LazySingle instance = null;

    public static synchronized LazySingle  get(){
        if(instance == null){
            instance = new LazySingle();
        }
        return instance;
    }
}


interface  test{
    public  void  eat();
    public static void drink(){
        System.out.println("");
    };
    public static ThreadLocal tl = new ThreadLocal();
    public static void main(String[] args) {
        tl.get();
    }

}