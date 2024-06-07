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
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        List<Integer> result = new ArrayList<>();
        dfs(root, 0, result);
        int sum = result.get(0);
        for (int i = 1; i < result.size(); i++)
            sum += result.get(i);
        return sum;
    }

    private void dfs(TreeNode root, int sum, List<Integer> result) {
        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            result.add(sum);
            return;
        }
        if (root.left != null)
            dfs(root.left, sum, result);
        if (root.right != null)
            dfs(root.right, sum, result);
    }

    public static void main(String[] args) {
        // Example usage
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        Solution solution = new Solution();
        System.out.println(solution.sumNumbers(root)); // Output should be 25 (12 + 13)
    }
}