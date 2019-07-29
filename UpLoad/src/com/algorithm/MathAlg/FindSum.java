package com.algorithm.MathAlg;

public class FindSum {
    public static boolean findTarget(int[] nums,int index,int target){
        if(index == nums.length){
            return false;
        }
        int temp = target - nums[index];
        if(temp == 0){
            return true;
        }else{
            if(temp < 0){
                return false;
            }
            return findTarget(nums,index+1,temp) || findTarget(nums,index+1,target);
        }
    }

    public static void main(String[] args) {
        int[] input = {1,5,11,5};
        System.out.println(findTarget(input,0,11));

    }
}
