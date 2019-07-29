package com.algorithm.Recursion;

import java.util.ArrayList;
import java.util.List;

public class StringDiv {
    private List<List<String>> res = new ArrayList<>();
    private List<String> temp = new ArrayList<>();
    public List<List<String>> partition(String s) {
        if(s == null || s.length() == 0){
            return res;
        }
        partition(s,0,s.length()-1);
        return res;
    }
    public void partition(String s,int b,int e) {
        if(b > e){
            List<String> t = new ArrayList<>(temp);
            res.add(t);
            return;
        }
        for(int i=b;i<=e;i++){
            if(isPalindrome(s,b,i)){
                temp.add(s.substring(b,i+1));
                partition(s,i+1,e);
                temp.remove(temp.size()-1);
            }
        }
    }
    public boolean isPalindrome(String s,int b,int e) {
        while(b<e && s.charAt(b) == s.charAt(e)){
            b++;
            e--;
        }
        return b>=e;
    }

    public static void main(String[] args) {
        StringDiv d = new StringDiv();
        String a = "aab";
        d.partition(a,0,2);
    }
}
