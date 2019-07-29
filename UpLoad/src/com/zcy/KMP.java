package com.zcy;

import java.util.Arrays;
import java.util.Comparator;

public class KMP {
    //找到则返回起始坐标，否则返回-1
    public static int doKMP(String s1,String s2){
        if(s1 == null){
            return -1;
        }
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        int i = 0;
        int j = 0;
        int[] next = getNext(s2);
        while(i < str1.length && j < str2.length){
            if(str1[i] == str2[j]){
                i++;
                j++;
            }else if(next[j] == -1){
                i++;
            }else{
                j = next[j];
            }
        }
        return j == str2.length ? i-j:-1;
    }
    public static int[] getNext(String s){
        int[] res = new int[s.length()];
        res[0] = -1;
        res[1] = 0;
        res[2] = s.charAt(0) == s.charAt(1) ? 1:0;
        for(int i = 3;i < s.length();i++){
            char c = s.charAt(i-1);
            int index = res[i-1];
            while(index != -1 && s.charAt(index) != c){
                index = res[index];
            }
            res[i] = index+1;
        }
        return res;
    }

    public static void main(String[] args) {
      /*  for(int i:getNext("ababcababak")){
            System.out.println(i);
        }*/
        int[][] array = {{10,16},{2,8},{1,6},{7,12}};
        Arrays.sort(array, Comparator.comparingInt(p->p[1]));
    }
}
