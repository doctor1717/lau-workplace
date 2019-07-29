package com.algorithm.RecallMethod;



import com.algorithm.CommonStruc.TreeNode;

import java.util.ArrayList;

//list代表每次遍历的路径 当左右子树的路径都递归返回后 该节点删除 递归返回上一层
public class RoadInTree{
    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> list = new ArrayList<Integer>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if(root == null) return listAll;
        list.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null)
            listAll.add(new ArrayList<Integer>(list));
        FindPath(root.left, target);
        FindPath(root.right, target);
        list.remove(list.size()-1);
        return listAll;
    }
}
