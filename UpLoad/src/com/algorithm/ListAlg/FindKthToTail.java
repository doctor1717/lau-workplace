package com.algorithm.ListAlg;

import com.algorithm.CommonStruc.ListNode;

//在链表中找到倒数第k个节点
public class FindKthToTail {
    public ListNode FindKthToTail(ListNode head, int k) {
    if(head == null || k <= 0){
        return null;
    }

    ListNode temp = head;
        for(int i= 1;i < k;i++){
        if(temp.next != null){
            temp = temp.next;
        }
        else{
            return null;
        }
    }
    ListNode ret = head;
        while(temp.next != null){
        temp = temp.next;
        ret = ret.next;
    }
        return ret;
}
}
