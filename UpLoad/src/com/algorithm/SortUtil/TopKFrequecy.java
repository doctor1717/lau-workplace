package com.algorithm.SortUtil;

import java.util.*;

public class TopKFrequecy {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int n:nums){
            if(map.containsKey(n)){
                map.put(n,map.get(n)+1);
            }
            else{
                map.put(n,1);
            }
        }
        ArrayList<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list,(a, b)->(b.getValue()-a.getValue()));
        List<Integer> res = new ArrayList<>();
        for(int i = 0;i<k;i++){
            res.add(list.get(i).getKey());
        }
        return res;
    }

    public static void main(String[] args) {
        TopKFrequecy t = new TopKFrequecy();
        int[] i = {1,1,1,2,2,3};
        t.topKFrequent(i,2);
    }
}
