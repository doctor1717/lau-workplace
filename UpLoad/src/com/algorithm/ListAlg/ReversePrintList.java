package com.algorithm.ListAlg;

import com.algorithm.CommonStruc.ListNode;

import java.util.ArrayList;

//递归或利用栈
public class ReversePrintList {
    public ArrayList<Integer> list = new ArrayList();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if(listNode == null){
            return list;
        }
        if(listNode.next != null){
            printListFromTailToHead(listNode.next);
        }
        list.add(listNode.val);
        return list;
    }
}


