package com.algorithm.CommonStruc;

import java.util.HashMap;
import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LRUCache {
    private HashMap<Integer,Entry> map;
    private Entry head;
    private Entry tail;
    private int cap;
    private int count;
    public LRUCache(int capacity) {
        cap = capacity;
        count = 0;
        map = new HashMap<>((int)(cap/0.75)+1);
        head = new Entry(-1,null);
        tail = head;
    }

    public int get(int key) {
        Entry cur = map.get(key);
        if(cur == null){
            return -1;
        }
        remove(cur);
        add(cur);
        return cur.val;
    }

    public void put(int key, int value) {
        Entry cur = map.get(key);
        if(cur != null){
            cur.val = value;
            remove(cur);
            add(cur);
            return;
        }
        Entry e = new Entry(key,value);
        count+=1;
        if(count > cap){
            map.remove(head.next.key);
            removeFromHead();
            count--;
        }
        map.put(key,e);
        add(e);
        return;
    }
    public void removeFromHead(){
        Entry temp = head.next.next;
        head.next.next = null;
        head.next.pre = null;
        head.next = temp;
        temp.pre = head;
    }
    public void remove(Entry e){
        if(e == tail){
            tail = tail.pre;
            tail.next = null;
            e.pre = null;
            return;
        }
        e.pre.next = e.next;
        e.next.pre = e.pre;
        e.next = null;
        e.pre = null;
    }
    public void add(Entry e){
        tail.next = e;
        e.pre = tail;
        tail = e;
    }

    public static void main(String[] args) {
        /*LRUCache c = new LRUCache(2);
        c.put(1,1);
        c.put(2,2);
        c.get(1);
        c.put(3,3);
        c.get(2);
        c.put(4,4);
        c.get(1);
        c.get(3);
        c.get(4);*/
        ExecutorService e = Executors.newFixedThreadPool(10);
        System.out.println(Solute.convertToBase7(-7));
    }
}
class Solute {
    public static String convertToBase7(int num) {
        if(num == 0){
            return "0";
        }
        Stack<Integer> stack = new Stack<>();
        StringBuilder res = new StringBuilder();
        if(num<0){
            res.append("-");
        }
        while(num != 0){
            stack.push(num%7);
            num = num/7;
        }
        while(!stack.isEmpty()){
            String t = null;
            if(num < 0){
                Integer i = -1*stack.pop();
                t = i.toString();
            }else{
                t = stack.pop().toString();
            }
            res.append(t);
        }
        return res.toString();
    }
}

class Entry{
    public Entry(Integer key,Integer val){
        this.key = key;
        this.val = val;
    }
    Integer key;
    Integer val;
    Entry next;
    Entry pre;
}

