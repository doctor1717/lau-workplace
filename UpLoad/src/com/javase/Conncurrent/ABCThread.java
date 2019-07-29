package com.javase.Conncurrent;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ABCThread {
    static Lock lock = new ReentrantLock();
    static Condition printA = lock.newCondition();
    static Condition printB = lock.newCondition();
    static Condition printC = lock.newCondition();

    static Object lock_A = new Object();
    static Object lock_B = new Object();
    static Object lock_C = new Object();
    public static void main(String[] args) throws InterruptedException {
        sol1();
    }
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0) return 0;
        Arrays.sort(points,(a, b) -> (a[1] - b[1]));
        int curPos = points[0][1];
        int ret = 1;
        for (int i = 1; i < points.length; i++) {
            if(points[i][0] <= curPos) {
                continue;
            }
            curPos = points[i][1];
            ret++;
        }
        return ret;
    }
    public static void sol(){

    }
    public static void sol1() throws InterruptedException {
        new Thread(new Runnable(){
            @Override
            public void run() {
                lock.lock();
                try{
                    for (int j = 0; j <10 ; j++) {
                        System.out.println("A");
                        printB.signal();
                        printA.await();

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }).start();
        Thread.sleep(10);
        new Thread(new Runnable(){
            @Override
            public void run() {
                lock.lock();
                try{
                    for (int j = 0; j <10 ; j++) {
                        System.out.println("B");
                        printC.signal();
                        printB.await();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }).start();
        Thread.sleep(10);
        new Thread(new Runnable(){
            @Override
            public void run() {
                lock.lock();
                try{
                    for (int j = 0; j <10 ; j++) {
                        System.out.println("C");
                        printA.signal();
                        printC.await();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }).start();
    }
}
