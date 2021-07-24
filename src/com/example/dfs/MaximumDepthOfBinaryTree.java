package com.example.dfs;

public class MaximumDepthOfBinaryTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(8);
        root.left.left.left = new TreeNode(7);

        MaximumDepthOfBinaryTree a = new MaximumDepthOfBinaryTree();

        int result = a.solve(root);

        System.out.println("result = " + result);
    }

    private int solve(TreeNode root) {

        return maxDepth(root);

    }

    static int maxDepth(TreeNode node) {
        if (node == null) return 0;
        int left = maxDepth(node.left);
        int right = maxDepth(node.right);
        return Math.max(left, right) +1;
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
