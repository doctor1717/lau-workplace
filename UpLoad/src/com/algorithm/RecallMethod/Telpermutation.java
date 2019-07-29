package com.algorithm.RecallMethod;

import java.util.ArrayList;
import java.util.List;

public class Telpermutation {
    private char[][] c = {{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},
            {'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
    private List<String> list = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        StringBuilder sb = new StringBuilder();
        letterCombinations(digits,0,sb);
        return list;
    }
    public void letterCombinations(String digits,int index,StringBuilder sb) {
        if(index == digits.length()){
            String res = sb.toString();
            list.add(res);
            return;
        }
        int temp = (int)digits.charAt(index)-'0';
        for(int i = 0;i<c[temp-2].length;i++){
            sb.append(c[temp-2][i]);
            letterCombinations(digits,index+1,sb);
            sb.deleteCharAt(index);
        }
    }

    public static void main(String[] args) {
         String i = "23";

        Telpermutation t = new Telpermutation();
        System.out.println(t.letterCombinations(i).toString());
    }
}
