package com.algorithm.ListAlg;

import com.algorithm.CommonStruc.ListNode;

//翻转链表，递归或循环都可以，循环需要保存三个节点A，B，C,AB反转时C不会丢失
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        return reverseList(head,head,head.next);
    }
    public ListNode reverseList(ListNode preHead,ListNode node,ListNode forwardNode){
        ListNode ret = null;
        if(forwardNode == null){
            return node;
        }
        if(forwardNode.next == null){
            forwardNode.next = node;
            return forwardNode;
        }
        ret = reverseList(preHead,forwardNode,forwardNode.next);
        forwardNode.next = node;
        if(node == preHead) {
            node.next = null;
        }
        return ret;
    }
}
