package com.zcy;

import java.util.LinkedList;
//滑动窗口结构
public class Window {
    //固定大小窗口，窗口中的最大值，以数组形式返回
    public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        int[] res = new int[nums.length-k+1];
        int index = 0;
        for(int i = 0;i < nums.length;i++){
            while(!list.isEmpty() && list.peekLast() <= nums[i]){
                list.pollLast();
            }
            list.addLast(i);
            if(i-k == list.peekFirst()){
                list.pollFirst();
            }
            if(i >= k-1){
                res[index++] = nums[list.peekFirst()];
            }
        }
        return res;
    }
    //找出所有子数组中最大值-最小值小于num的子数组数量
    public int doCount(int[] input,int num){
        int res = 0;
        LinkedList<Integer> qmax = new LinkedList<>();
        LinkedList<Integer> qmin = new LinkedList<>();
        int L = 0;
        int R = 0;
        while(L < input.length){
            while(R < input.length){
                while(!qmax.isEmpty() && input[qmax.peekLast()] <= input[R]){
                    qmax.pollLast();
                }
                while(!qmin.isEmpty() && input[qmin.peekLast()] >= input[R]){
                    qmin.pollLast();
                }
                qmax.addLast(R);
                qmax.addLast(R);
                if(qmax.getFirst()-qmin.getFirst() > num){
                    break;
                }
                R++;
            }
            if(qmax.getFirst() == L){
                qmax.pollFirst();
            }
            if(qmin.getFirst() == L){
                qmin.pollFirst();
            }
            res += R - L;
            L++;
        }
        return res;
    }

    public static void main(String[] args) {
        LinkedList<Integer> max = new LinkedList<>();
        System.out.println(max.peekFirst());
    }
}
