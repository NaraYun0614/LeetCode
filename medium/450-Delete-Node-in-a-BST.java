/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        // case1: node has no children -> it's leaf -> just delete
        // case2: node has one child -> replace node with it's child
        // case3: node has two children -> replace node with inorder successor
        if (root == null) return null;

        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else { // node to delete is found
            // case 1
            if (root.left == null && root.right == null) return null;

            // case 2
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            // case 3
            // get smallest from right subtree -> copy the value -> delete the copy node
            TreeNode successor = findMin(root.right);
            root.val = successor.val;
            root.right = deleteNode(root.right, successor.val);
        }
        return root;
    }

    private TreeNode findMin(TreeNode node) { // find the smallest node -> leftmost
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}