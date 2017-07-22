/**
 * http://www.lintcode.com/en/problem/identical-binary-tree/
 */

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
    private boolean isIdentical = true;
    /**
     * @param a, b, the root of binary trees.
     * @return true if they are identical, or false.
     */
    public boolean isIdentical(TreeNode a, TreeNode b) {
        // Write your code here
        walk(a, b);
        
        return this.isIdentical;
    }
    
    private void walk(TreeNode a, TreeNode b) {
        if ((a == null && b == null) || !this.isIdentical) {
            return;
        }
        
        if (a == null && b != null || a != null && b == null) {
            this.isIdentical = false;
            return;
        }
        
        if (a.val != b.val) {
            this.isIdentical = false;
        }
        
        if (a.left != null) {
            walk(a.left, b.left);
        }
        
        if (a.right != null) {
            walk(a.right, b.right);
        }
    }
}