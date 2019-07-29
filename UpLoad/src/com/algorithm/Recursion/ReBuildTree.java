package com.algorithm.Recursion;
//根据前序和中序序列重建二叉樹
public class ReBuildTree {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre == null || in == null){
            return null;
        }
        int len = pre.length;
        return reConstructBinaryTree(pre,in,0,len-1,0,len-1);
    }
    public TreeNode reConstructBinaryTree(int[] pre,int[] in,int beg,int end,int midBeg,int midEnd) {

        if(beg > end || midBeg > midEnd) {
            return null;
        }
        TreeNode node = new TreeNode(pre[beg]);

        int targetIndex = findIndex(in,pre[beg]);

        int leftLen = targetIndex - midBeg;
        int rightLen = midEnd - targetIndex;

        int rightBeg = end - rightLen + 1;
        int rightEnd = end;
        int leftBeg = beg + 1;
        int leftEnd = leftBeg + leftLen - 1;


        node.left = reConstructBinaryTree(pre, in, leftBeg, leftEnd, midBeg, midBeg + leftLen -1);
        node.right = reConstructBinaryTree(pre, in, rightBeg, rightEnd, midEnd - rightLen +1, midEnd);
        return node;
    }
    public int findIndex(int[] in,int target){
        for (int i = 0; i < in.length ; i++) {
            if(target == in[i]) {
                return i;
            }
        }
        return -1;
    }

}
 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
