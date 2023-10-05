/*
How To write a function that adds elements of a binary tree to a LIst level by level, changing the direction of adding for every level.
             1
          2      3
        4   5  6   7
          8  9
          
          result: 1-3-2-4-5-6-7-9-8
       
*/

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
    }
}

public class BinaryTreeLevelPrint {
    public static List<Integer> printLevelByLevel(TreeNode root) {
        List<Integer> resList = new ArrayList<>();

        if (root == null) {
            return resList;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();

        boolean reverse = false;

        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();

                if (reverse) {
                    stack.push(node);
                } else {
                    resList.add(node.val);
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            while (!stack.isEmpty()) {
                resList.add(stack.pop().val);
            }

            reverse = !reverse;
        }

        return resList;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.right.left = new TreeNode(8);
        root.left.right.right = new TreeNode(9);

        List<Integer> strangeList = printLevelByLevel(root);
        strangeList.forEach(System.out::print);
    }
}
