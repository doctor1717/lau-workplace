package com.zcy;
//单调栈结构

import java.util.Stack;

public class DullStack {
    //找到每个元素最近的大于该元素的两个数

    //直方图的最大矩形[4,3,2,5,6]
    public static int maxRecFromBottom(int[] height){
        if(height == null || height.length ==0){
            return 0;
        }
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < height.length;i++){
            while(!stack.isEmpty() && height[i] < height[stack.peek()]){
                int j = stack.pop();
                int k = stack.isEmpty() ? -1:stack.peek();
                int curArea = (i-k-1)*height[j];
                max = Math.max(max,curArea);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int j = stack.pop();
            int k = stack.isEmpty() ? -1:stack.peek();
            int curArea = (height.length - k -1)*height[j];
            max = Math.max(max,curArea);
        }
        return max;
    }
}
