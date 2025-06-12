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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> currPath = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        dfs(root, targetSum, currPath, result);
        return result;
    }

    private void dfs(TreeNode node, int targetSum, List<Integer> path, List<List<Integer>> result) {
        if (node == null) return;
        path.add(node.val);

        // check if the node is leaf && eqaul to targetSum
        if (node.left == null && node.right == null && node.val == targetSum) {
            result.add(new ArrayList<>(path));  // make a copy of current path
        }

        dfs(node.left, targetSum - node.val, path, result);
        dfs(node.right, targetSum - node.val, path, result);

        // Backtracking, removes last value from the path to try other paths
        path.remove(path.size() - 1);
    }
}