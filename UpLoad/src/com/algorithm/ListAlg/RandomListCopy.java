package com.algorithm.ListAlg;

import java.util.HashMap;

public class RandomListCopy {
    //通过新节点和原链表节点放入HashMap的映射关系，完成新节点的指针赋值
    //还可以通过把每个节点在原地复制，之后再删除原节点完成
    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead == null){
            return null;
        }
        HashMap<RandomListNode,RandomListNode> map = new HashMap<>();
        RandomListNode temp = pHead;
        while(temp != null){
            RandomListNode newNode = new RandomListNode(temp.label);
            map.put(temp, newNode);
            temp = temp.next;
        }
        for(RandomListNode i = pHead;i != null;i=i.next) {
            map.get(i).next = map.get(i.next);
            map.get(i).random = map.get(i.random);
        }
        return map.get(pHead);
    }
}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
