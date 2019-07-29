package com.algorithm.Recursion;

public class BTreeToList {
    //利用中序遍历 将二叉搜索树变为双向链表
    static class TreeNode{
        public TreeNode(int v) {
            val = v;
        }
            int val = 0;
            TreeNode left = null;
            TreeNode right = null;
    };
    private BTreeToList.TreeNode temp = null;
    private BTreeToList.TreeNode head = null;

    public BTreeToList.TreeNode turnToList(BTreeToList.TreeNode root){
        if(root == null){
            return null;
        }
        turnToList(root.left);
        if(temp == null){
            temp = root;
            head = root;
        }
        else{
            root.left = temp;
            temp.right = root;
            temp = root;//保存本节点
        }
        turnToList(root.right);
        return head;
    }
}
