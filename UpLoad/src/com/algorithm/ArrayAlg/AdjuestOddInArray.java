package com.algorithm.ArrayAlg;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

//用空间换时间，也可以在原地移动，将奇数与偶数之间的序列整体后移一位，再将奇数插入到前面
//更加优化的解法 利用插入排序的思想 是奇数就前移 保持局部都是奇数即可，利用了插入排序是原地排序的特点
public class AdjuestOddInArray {
    public ExecutorService e = Executors.newCachedThreadPool();
    public void reOrderArray(int [] array) {
        if(array == null){
            return;
        }
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        for(int i:array){
            if((i&1)==1){
                list1.add(i);
            }
            if((i&1)==0){
                list2.add(i);
            }
        }
        list1.addAll(list2);
        System.out.println(list1.toString());
        for(int i = 0;i<list1.size();i++) {
            array[i] = list1.get(i);
        }
    }
}
