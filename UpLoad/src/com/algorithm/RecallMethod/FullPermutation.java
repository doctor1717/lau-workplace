package com.algorithm.RecallMethod;

import java.util.Arrays;

public class FullPermutation {
    public static void Ops(String input){
        char[] c = input.toCharArray();
        Ops(c,0);
    }
    public static void Ops(char[] c,int index){
        if(index == c.length-1){
            System.out.println(Arrays.toString(c));
        }
        for(int i = index;i < c.length;i++){
             swap(c,index,i);
             Ops(c,index+1);
             swap(c,index,i);
        }
    }
    public static void swap(char[] c,int b,int e){
        char temp = c[b];
        c[b] = c[e];
        c[e] = temp;
    }

    public static void main(String[] args) {
        Ops("abcd");
    }
}
