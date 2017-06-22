/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    private int max = 0;
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int maxDepth(TreeNode root) {
        // write your code here
        helper(root, 0);
        return max;
    }
    
    void helper(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        
        depth += 1;
        
        if (depth > max) {
            max = depth;
        }
        
        helper(root.left, depth);
        helper(root.right, depth);
    }
}