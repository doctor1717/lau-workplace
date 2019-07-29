package com.algorithm.MathAlg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length < 3){
            return res;
        }
        Arrays.sort(nums);
        for(int i = nums.length-1;i>=2;i--){
            int k = 0;
            int j = i-1;
            while(k < j){
                if(nums[k] + nums[j]<-nums[i]){
                    k++;
                }else if(nums[k] + nums[j] > -nums[i]){
                    j--;
                }else{
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    res.add(list);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] input = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(input).toString());
    }
}
