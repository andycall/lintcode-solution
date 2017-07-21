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
    /**
     * @param root: The root of binary tree
     * @return root of new tree
     */
    public TreeNode cloneTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        
        // Write your code here
        TreeNode dummy = new TreeNode(root.val);
        
        clone(root, dummy);
        
        return dummy;
    }
    
    private void clone(TreeNode oldRoot, TreeNode newRoot) {
        if (oldRoot.left != null) {
            newRoot.left = new TreeNode(oldRoot.left.val);
            clone(oldRoot.left, newRoot.left);
        }
        
        if (oldRoot.right != null) {
            newRoot.right = new TreeNode(oldRoot.right.val);
            clone(oldRoot.right, newRoot.right);
        }
    }
}