package com.javase.Conncurrent;

public class ThreadInterrupt {
    public static void main(String[] args) {
        Thread a = new Thread(new ta());
        a.start();
        Thread b = new Thread(new tb());
        b.start();
        a.interrupt();
        b.interrupt();
    }
}
class ta implements Runnable{
    @Override
    public void run() {
        while(true){
            System.out.println("a");
        }
    }
}
class tb implements Runnable{
    @Override
    public void run() {
        while(true){
            System.out.println("b");
        }
    }
}