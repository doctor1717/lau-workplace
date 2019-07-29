package com.algorithm.Recursion;


import com.algorithm.CommonStruc.TreeNode;

public class SubStructure {
    //从Tree1的头节点开始，每个节点都有与Tree2相同结构的可能性d'd
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean res = false;
        if(root1 == null || root2 == null) {
            return res;
        }
        if(root1.val == root2.val) {
            res = JudgeStucture(root1, root2);
        }
        if(res == false) {
            res = HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
        }
        return res;
    }
    //从两个个节点为起点，递归比较两个树结构
    public  boolean JudgeStucture(TreeNode root1,TreeNode root2) {
        if(root2 == null) {
            return true;
        }
        if(root1 == null) {
            return false;
        }
        if(root1.val != root2.val) {
            return false;
        }
        return JudgeStucture(root1.left, root2.left) && JudgeStucture(root1.right, root2.right);
    }
}
