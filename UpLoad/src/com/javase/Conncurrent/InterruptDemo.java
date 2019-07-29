package com.javase.Conncurrent;
//中断可用于取消和停止任务
public class InterruptDemo {
    public static void main(String[] args) {
            Thread s = new Thread(new SleepRunner(),"ST");
            Thread b = new Thread(new BusyRunner(),"BT");
            s.start();
            b.start();
        try {
            Thread.sleep(10);
            s.interrupt();
            b.interrupt();
            System.out.println(s.isInterrupted());
            System.out.println(b.isInterrupted());
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    static class SleepRunner implements Runnable{
        @Override
        public void run() {
            while(true){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    static class BusyRunner implements Runnable{
        @Override
        public void run() {
            while(true){
            }
        }
    }
}
