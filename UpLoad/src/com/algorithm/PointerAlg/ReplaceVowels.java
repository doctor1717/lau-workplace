package com.algorithm.PointerAlg;

import java.util.Arrays;
import java.util.HashSet;

public class ReplaceVowels {
    private static final HashSet<Character> set = new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
    public String doReplace(String input){
        char[] c = input.toCharArray();
        int beg = 0;
        int tail = c.length-1;
        while(beg < tail){
            if(set.contains(c[beg]) && set.contains(c[tail])){
                char temp = c[beg];
                c[beg] = c[tail];
                c[tail] = temp;
            }else if(set.contains(c[beg])){
                tail--;
            }else if(set.contains(c[tail])){
                beg++;
            }else{
                tail--;
                beg++;
            }
        }
        return String.valueOf(c);
    }
}
