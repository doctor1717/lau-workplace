package com.algorithm.Dp;
//斐波那契序列，递归或循环，递归计算的重复值较多
public class Fibonacci {
    public int Fibonacci(int n) {
        if(n <= 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        else{
            return Fibonacci(n-1) + Fibonacci(n-2);
        }
    }
    public int JumpFloor(int target) {
        if(target == 0){
            return 0;
        }
        if(target == 1){
            return 1;
        }
        if(target == 2){
            return 2;
        }
        int index = 3;
        int prepre = 1;
        int pre = 2;
        int temp = 0;
        while(true){
            temp = prepre + pre;
            prepre = pre;
            pre = temp;
            if(index == target){
                return temp;
            }
            else{
                index++;
            }
        }
    }
    //可以跳1，n阶
    public int JumpFloorII(int target) {
        if(target == 1){
            return 1;
        }
        if(target == 2){
            return 2;
        }
        return 2*JumpFloorII(target-1);
    }
    //用2*1的小矩形横着或者竖着去覆盖更大的矩形。问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形
    public int RectCover(int target) {
        return JumpFloor(target);
    }
}
