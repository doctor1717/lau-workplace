package com.javase.Conncurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//实现一个有界队列 对列为空时获取线程阻塞 队列满时插入线程阻塞
// 使用Condition与Lock 类似于Synchronized与wait/notify的等待通知模式
public class ConditionDemo<T> {


}
class BoundedQueue<T>{
    private Lock lock = new ReentrantLock();
    private Condition notEmpty = lock.newCondition();
    private Condition notFull = lock.newCondition();
    private Object[] items;
    private int addIndex,removeIndex,count;

    public BoundedQueue(int size) {
        items = new Object[size];
    }
    public void add(T t) throws InterruptedException {
        lock.lock();
        try {
            while (count == items.length) {
                notFull.await();
            }
            items[addIndex] = t;
            if (++addIndex == items.length) {
                addIndex = 0;
            }
            ++count;
            notEmpty.signal();
        }
        finally{
            lock.unlock();
        }
    }
}