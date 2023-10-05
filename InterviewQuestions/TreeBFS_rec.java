class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}

public class BinaryTreeLevelOrderTraversal {
    public static void printLevelOrder(TreeNode root) {
        int height = getHeight(root);

        for (int i = 1; i <= height; i++) {
            printLevel(root, i);
            System.out.println(); // Move to the next level
        }
    }

    private static void printLevel(TreeNode node, int level) {
        if (node == null)
            return;
        if (level == 1)
            System.out.print(node.val + " ");
        else if (level > 1) {
            printLevel(node.left, level - 1);
            printLevel(node.right, level - 1);
        }
    }

    private static int getHeight(TreeNode root) {
        if (root == null)
            return 0;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println("Level-order traversal:");
        printLevelOrder(root);
    }
}

