/*
How To write a function that prints elements of a binary tree level by level (starting from the bottom one), changing the direction of adding for every level.
             1
          2      3
        4   5  6   7
          8  9

result print:
9 8
4 5 6 7
3 2
1

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
    public static void printLevelByLevelUpsideDown(TreeNode root) {
        Stack<Integer> resStack = new Stack<>();
        Stack<Integer> tmpStack = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) {
            return;
        }

        boolean reverse = true;
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();

                if (reverse) {
                    tmpStack.push(node.val);
                } else {
                    resStack.push(node.val);
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            while (!tmpStack.isEmpty()) {
                resStack.push(tmpStack.pop());
            }

            resStack.push(levelSize);
            reverse = !reverse;
        }

        while (!resStack.isEmpty()) {
            int numOfElementsOnLevel = resStack.pop();
            for (int i = 0; i < numOfElementsOnLevel; i++) {
                System.out.print(resStack.pop() + " ");
            }
            System.out.println();
        }
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

        printLevelByLevelUpsideDown(root);
    }
}
