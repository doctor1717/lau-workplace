package com.algorithm.SortUtil;

import java.util.Arrays;

public class SortUtil {
    public static void main(String[] args) {
        int[] a = {1,10,2,8,7,5,4,3,5,2,11,4,20};
        SortUtil s = new SortUtil();
        s.qS(a);
        System.out.println(Arrays.toString(a));
    }
    public void qS(int[] input){
        quikSort(input,0,input.length-1);
    }
    public void quikSort(int[] input,int lo,int hi){
        if(lo >= hi){
            return;
        }
        int[] res = partition(input,lo,hi);
        quikSort(input,lo,res[0]);
        quikSort(input,res[1],hi);
    }
    public int[] partition(int[] input,int lo,int hi){
        int s = lo-1;
        int e = hi;
        while(lo < e){
            if(input[lo] < input[hi]){
                s++;
                lo++;
            }
            else if(input[lo] > input[hi]){
                swap(input,--e,lo);
            }
            else{
                lo++;
            }
        }
            swap(input,hi,e);
        return new int[]{s,e+1};
    }
    public void swap(int[] input,int i1,int i2){
        int temp = input[i1];
        input[i1] = input[i2];
        input[i2] = temp;
    }
}
