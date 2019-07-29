package com.algorithm.RecallMethod;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class IpDiv {
    private List<String> res = new ArrayList<>();
    private StringBuilder temp = new StringBuilder();
    public List<String> restoreIpAddresses(String s) {
        restoreIpAddresses(s,0);
        return res;
    }
    public void restoreIpAddresses(String s,int index) {
        if(s.length() == 0 && index == 4){
            String t = temp.toString();
            String r = t.substring(0,t.length()-1);
            res.add(r);
            return;
        }
        else if(s.length() == 0 && index != 4){
            return;
        }
        if(index == 4 && s.length() != 0){
            return;
        }
        for(int i = 1;i<4;i++){
            if(i > s.length()){
                continue;
            }
            String sub = s.substring(0,i);
            int val = Integer.valueOf(sub);
            if((val>0&&val<256&&sub.charAt(0)!='0') || (val==0&&i==1)){
                temp.append(sub+".");
                restoreIpAddresses(s.substring(i),index+1);
                temp.delete(temp.length()-i-1,temp.length());
            }
            else{
                continue;
            }
        }
        return;
    }


    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        LinkedHashSet<String> set = new LinkedHashSet<>();
        set.add("d");
        set.add("a");
        set.add("b");
        set.add("c");
        HashSet<String> set_1 = new HashSet<>();
        set_1.add("d");
        set_1.add("a");
        set_1.add("b");
        set_1.add("c");
        for(String s:set){
            System.out.println(s);
        }
        for(String s:set_1){
            System.out.println(s);
        }
    }
}
