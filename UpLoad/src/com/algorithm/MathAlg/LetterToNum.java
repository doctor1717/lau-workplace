package com.algorithm.MathAlg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetterToNum{
    public static int Change(String input){
        char[] c = input.toCharArray();
        int sum = 0;
        for(int i = 0;i<c.length;i++){
            int temp = c[i]-'A';
            sum += temp*Math.pow(26,i);
        }
        return sum;

    }
    public static List<Integer> partitionLabels(String S) {
        List<Integer> list = new ArrayList<>();
        if(S == null || S.length() == 0){
            return list;
        }
        char[] c = S.toCharArray();
        int[] count = new int[26];
        for(int i = 0;i < c.length;i++){
            int index = c[i]-'a';
            count[index] = i;
        }
        int k = 0;
        while(k < c.length){
            int t = count[c[k]-'a'];
            for (int j = k + 1; j < t && j < c.length; j++) {
                if (count[c[j]-'a'] > t) {
                    t = count[c[j]-'a'];
                }
            }
            list.add(t - k + 1);
            k = t + 1;
        }
            return list;
    }
    public static void main(String[] args) {
        System.out.println(partitionLabels("ababcbacadefegdehijhklij").toString());
    }
}
