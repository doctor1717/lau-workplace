package com.algorithm.MathAlg;

public class BitMath {
    //求数字中1的个数，按位移动1即可
    public int NumberOf1(int n) {
        int a = 1;
        int i = 0;
        int count = 0;
        while(i < 32){
            if((n&a) == a){
                count++;
            }
            a = a << 1;
            i++;
        }
        return count;
    }
}
