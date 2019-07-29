package com.algorithm.MathAlg;

import java.util.ArrayList;

public class GreyCode {
    private ArrayList<ArrayList<Integer>> res = new ArrayList<>();

   /* public static ArrayList<ArrayList<Integer>> buildGrey(int n){
   *//*     Integer[] temp = new Integer[n];
        int count = (int)Math.pow(2,n);
        int index = 1;
        res.add(Arrays.asList(temp));
        while(index != count){
            if((index&1) != 1){
                temp[n-1] ^= 1;
            }
            else{
                int i = n-1;
                int j = 1>>(n-1);
                while((temp[i]&j)!=1){
                    j=j<<1;
                    i++;
                }
                temp[i-1]^=1;
            }
            index++;
        }
        return res;*//*
    }*/
   public static int findGrey(int n,int k){
       if(n > Math.pow(2,n)-1){
           return -1;
       }
       return k^(k>>1);
   }
    public static void main(String[] args) {
        System.out.println(findGrey(3,3));
    }
}
