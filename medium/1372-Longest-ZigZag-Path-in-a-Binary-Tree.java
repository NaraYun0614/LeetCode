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
    int maxLength = 0;

    public int longestZigZag(TreeNode root) {
        if (root == null) return 0;

        dfs(root.left, 1, true);
        dfs(root.right, 1,  false);
        return maxLength;
    }

    private void dfs(TreeNode node, int length, boolean isLeft) {
        if (node == null) return;

        maxLength = Math.max(maxLength, length);

        if (isLeft) {   // last move was left -> go to right
            dfs(node.right, length + 1, false);
            dfs(node.left, 1, true);    // restart to find the path
        } else {    // last move was right -> go to left
            dfs(node.left, length + 1, true);
            dfs(node.right, 1, false);  // restart if same direction again
        }
    }
}