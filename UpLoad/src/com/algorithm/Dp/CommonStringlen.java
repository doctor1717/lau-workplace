package com.algorithm.Dp;

public class CommonStringlen {
    public int CommenStringlength(String s1,String s2){
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];
        int max = 0;
        for(int i = 1;i < n+1;i++){
            for(int j = 1;j < m+1;j++){
                dp[i][j] = s1.charAt(i-1) == s2.charAt(j-1)?dp[i-1][j-1]+1:0;
                if(dp[i][j] > max){
                    max = dp[i][j];
                }
            }
        }
        return max;
    }
    public static void main(String[] args) {
        CommonStringlen dp = new CommonStringlen();
        String s1 = "abcdefg";
        String s2 = "defghi";
        System.out.println(dp.CommenStringlength(s1,s2));
    }
}