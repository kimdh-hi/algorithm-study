package com.example.queue;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

/**
 * 2진 트리구조를 레벨 단위로 나누기
 */
public class LevelOrderOfBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        LevelOrderOfBinaryTree a = new LevelOrderOfBinaryTree();
        List<List<Integer>> result = a.solve(root);

        for (List<Integer> r : result) {
            for(Integer i : r) {
                System.out.print(i +" ");
            }
            System.out.println();
        }
    }

    private List<List<Integer>> solve(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i=0;i<size;i++) {
                TreeNode node = q.poll();
                tmp.add(node.val);
                if(node.left != null) {
                    q.offer(node.left);
                }
                if(node.right != null) {
                    q.offer(node.right);
                }
            }
            res.add(tmp);
        }
        return res;
    }

    static class TreeNode {
        public Integer val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
}
