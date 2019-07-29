package com.algorithm.PointerAlg;

public class CycleString {
    public boolean validPalindrome(String s) {
        int beg = 0;
        int tail = s.length()-1;
        boolean signal = false;
        while (beg < tail) {
            if (s.charAt(beg) == s.charAt(tail)) {
                beg++;
                tail++;
            }
            else if(beg+1 < s.length() && s.charAt(beg+1) == s.charAt(tail) && signal == false){
                beg++;
                signal = true;
            }else if(tail - 1 > 0 && s.charAt(beg) == s.charAt(tail-1) && signal == false){
                tail--;
                signal = true;
            }else{
                return false;
            }
        }
        return true;
    }
}
