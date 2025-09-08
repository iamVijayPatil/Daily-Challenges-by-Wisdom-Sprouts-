/*Day 25 of 30 🗓

Problem : Check if a Binary Tree is a Binary Search Tree (BST)
You are given the root of a binary tree. Your task is to determine whether the tree is a valid Binary Search Tree (BST)

Input :
* A binary tree represented by its root node.
* Input: root = [2, 1, 3]

Output :
Return true if the binary tree is a valid BST, otherwise return false.
Output: true */
public class Problem25 {

    public static void main(String[] args) {
        // Example: root = [2, 1, 3]
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        System.out.println(isValidBST(root));  // Output: true
    }

    // Definition for a binary tree node
    public static class TreeNode {

        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    // Main function to check if tree is BST
    public static boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    // Helper function with range validation
    private static boolean isValid(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }

        // Check if node violates the BST property
        if (node.val <= min || node.val >= max) {
            return false;
        }

        // Recursively check left and right subtrees
        return isValid(node.left, min, node.val)
                && isValid(node.right, node.val, max);
    }
}
