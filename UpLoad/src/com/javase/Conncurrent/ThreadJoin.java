package com.javase.Conncurrent;
//x.join也可以使当前线程进入等待状态，x线程终止后，该方法返回
public class ThreadJoin {
    public static void main(String[] args) throws Exception{
        Thread previous = Thread.currentThread();
        for(int i = 0;i < 10;i++){
            Thread temp = new Thread(new Domino(previous));
            previous = temp;
            temp.start();
        }
        System.out.println(Thread.currentThread().getName() + "end");
    }
    static class Domino implements Runnable{
        private Thread thread;

        public Domino(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "end");
        }
    }
}
