package com.algorithm.SortUtil;

import com.sun.org.apache.xerces.internal.parsers.CachingParserPool;

public class HeapSort {
    public static int[] doSort(int[] input){
        doAdjust(input,input.length-1);
        int end = input.length-1;
        for(int i = 0;i < input.length;i++){
            swap(input,end,0);
            end--;
            doAdjust(input,end);
        }
        return input;
    }
    public static void doAdjust(int[] input,int end){
        int index = ((end+1)>>1)-1;
        while(index >= 0){
            int i = 2*index+2<=end && input[2*index+2]<input[2*index+1]?2*index+2:2*index+1;
            if(input[index] > input[i]){
                swap(input,index,i);
            }
            index--;
        }
    }
    public static void swap(int[] input,int i,int j){
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
    public static void bSort(int[] input){
        if(input == null){
            return;
        }
        int len = input.length-1;
        for(int i = len;i>0;i--){
            for(int j = 0;j<i;j++){
                if(input[j]>input[j+1]){
                    swap(input,j,j+1);
                }
            }
        }
    }
    public static void iSort(int[] input){
        int len = input.length;
        for(int i = 0;i < len;i++){
            for(int j = i;j > 0;j--){
                if(input[j] < input[j-1]){
                    swap(input,j,j-1);
                }
            }
        }
    }

    private static int[] temp;
    public static void mSort(int[] input,int lo,int hi){
        if(input == null || input.length == 1){
            return;
        }
        int mid = lo+(hi-lo)>>1;
        mSort(input,lo,mid);
        mSort(input,mid+1,hi);
/*
        Merge(input,lo,mid,hi);
*/
    }
 /*   public static void Merge(int[] input,int lo,int mid,int hi){
        int i = lo;
        int j = mid+1;
        for (int t=lo;t<=hi;t++) {
            temp[t]
        }
        while(index != len-1){
            if(lo == mid && ){

            }
        }
    }*/

    public static void main(String[] args) {
        int[] input = {4,2,9,3,1,12,5};
        /*doSort(input);*/
        iSort(input);
        for(int i:input){
            System.out.println(i);
        }
        String s = "abcdef";
        char[] c = s.toCharArray();
        for(char temp:c){
            String.valueOf(c);
        }
    }
}
