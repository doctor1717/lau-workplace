package com.algorithm.MathAlg;
//先算出需要增加的长度，再进行替换O(n)的复杂度
public class ReplaceInString {
    public String replaceSpace(StringBuffer str) {
        if(str == null) {
            return null;
        }
        int len = str.length();
        String replacePart = "%20";
        int count = 0;
        for (int i = 0; i < len; i++) {
            if(str.charAt(i) == ' ') {
                count++;
            }
        }
        int increaceCount = count*2;
        StringBuffer str2 = new StringBuffer(len+increaceCount);
        int preIndex = 0;
        for (int i = 0; i < len; i++) {
            if(str.charAt(i) == ' ') {
                String temp = str.substring(preIndex, i);
                preIndex = i+1;
                str2.append(temp);
                str2.append(replacePart);
            }
        }
        str2.append(str.substring(preIndex));
        return str2.toString();
    }
}
