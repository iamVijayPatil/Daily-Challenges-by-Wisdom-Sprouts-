/*
Problem : Lowest Common Ancestor (LCA) in a Binary Tree
You are given a binary tree and two distinct nodes within the tree. Your task is to find the lowest common ancestor (LCA) of these two nodes. The LCA of two nodes p and q is defined as the lowest node in the tree that has both p and q as descendants (where we allow a node to be a descendant of itself).

Input :
* A binary tree represented as a series of nodes where each node has references to its left and right child.
* Two distinct nodes p and q from the tree.
* Input: root = [3, 5, 1, 6, 2, 0, 8, null, null, 7, 4], p = 5, q = 1

Output :
Return the node that is the lowest common ancestor (LCA) of p and q.

 */
import java.util.*;

class TreeNode {

    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
    }
}

public class Problem24 {

    // Function to find LCA
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return (left != null) ? left : right;
    }

    // Helper function to build tree from array (level order)
    public static TreeNode buildTree(Integer[] arr) {
        if (arr.length == 0 || arr[0] == null) {
            return null;
        }

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (i < arr.length) {
            TreeNode current = queue.poll();

            if (i < arr.length && arr[i] != null) {
                current.left = new TreeNode(arr[i]);
                queue.add(current.left);
            }
            i++;

            if (i < arr.length && arr[i] != null) {
                current.right = new TreeNode(arr[i]);
                queue.add(current.right);
            }
            i++;
        }

        return root;
    }

    // Helper to find node by value
    public static TreeNode findNode(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        TreeNode left = findNode(root.left, val);
        if (left != null) {
            return left;
        }
        return findNode(root.right, val);
    }

    public static void main(String[] args) {
        // Example input
        Integer[] arr = {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
        TreeNode root = buildTree(arr);

        // Nodes p and q
        TreeNode p = findNode(root, 5);
        TreeNode q = findNode(root, 1);

        TreeNode lca = lowestCommonAncestor(root, p, q);

        System.out.println("Lowest Common Ancestor of " + p.val + " and " + q.val + " is: " + lca.val);
    }
}
