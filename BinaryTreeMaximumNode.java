public class Solution {
    /**
     * @param root the root of binary tree
     * @return the max ndoe
     */
    public TreeNode maxNode(TreeNode root) {
        // Write your code here
        if (root == null) {
            return root;
        }
        
        TreeNode left = maxNode(root.left);
        TreeNode right = maxNode(root.right);
        
        return max(root, max(left, right));
    }
    
    private TreeNode max(TreeNode left, TreeNode right) {
        if (left == null) {
            return right;
        }
        else if (right == null) {
            return left;
        }
        else if (left.val > right.val) {
            return left;
        }
        
        return right;
    }
}