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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        // create 2 arrayList to hold all leaves values for each tree
        // call a helper func to collect all the leaf values
        // helper func -> recursive fuc

        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();

        getLeaves(root1, leaves1);
        getLeaves(root2, leaves2);

        return leaves1.equals(leaves2);

    }

    private void getLeaves(TreeNode node, List<Integer> leaves) {
        if (node == null) return;

        if (node.left == null && node.right == null) { // No children
            leaves.add(node.val);
            return;
        }

        getLeaves(node.left, leaves);
        getLeaves(node.right, leaves);
    }
}