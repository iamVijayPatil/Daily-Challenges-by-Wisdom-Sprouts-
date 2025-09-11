/*Day 28 of 30 🗓

Problem : Check if a Binary Tree is Symmetric
You are given the root of a binary tree. Your task is to determine whether the tree is symmetric. A binary tree is symmetric if the left and right subtrees are mirror images of each other.

Input :
* The root of the binary tree.
* Input : [1, 2, 2, 3, 4, 4, 3]

Output :
Return true if the binary tree is symmetric, otherwise return false.
Output: true

 */
// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
    }
}

public class Problem28 {

    // Function to check if a binary tree is symmetric
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true; // An empty tree is symmetric
        return isMirror(root.left, root.right);
    }

    // Helper function to check if two trees are mirror images
    private static boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;

        return (t1.val == t2.val) &&
               isMirror(t1.left, t2.right) &&
               isMirror(t1.right, t2.left);
    }

    public static void main(String[] args) {
        // Example: [1, 2, 2, 3, 4, 4, 3]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println(isSymmetric(root)); // Output: true
    }
}

