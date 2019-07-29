package com.javase.DesignMod;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Factory {
    public animal getAnimal(Class c){
        animal a = null;
        try{
            a = (animal)c.newInstance();
        }catch(Exception e){
        }
        return a;
    }

    public static void main(String[] args) {
        Factory factory = new Factory();
        animal one = factory.getAnimal(cat.class);
        animal two = factory.getAnimal(dog.class);
        one.eat();
        two.eat();
        ExecutorService e = Executors.newFixedThreadPool(10);
    }
}
interface  animal{
    void eat();
}
class cat implements  animal{
    public void eat(){
        System.out.println("cat eat");
    }
}
class dog implements  animal{
    public void eat(){
        System.out.println("dog eat");
    }
}

