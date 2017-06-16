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
    private class ResultType {
        boolean isBst;
        int maxValue;
        int minValue;
        public ResultType(boolean isBst, int max, int min) {
            this.isBst = isBst;
            this.maxValue = max;
            this.minValue = min;
        }
    }
    
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        // write your code here
        if (root == null) {
            return true;
        }
        
        ResultType rt = helper(root);
        
        return rt.isBst;
    }
    
    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(true, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        
        ResultType leftResult = helper(root.left);
        ResultType rightResult = helper(root.right);
        
        if (!leftResult.isBst || !rightResult.isBst) {
            return new ResultType(false, 0, 0);
        }
        
        if (root.left != null && leftResult.maxValue >= root.val ||
            root.right != null && rightResult.minValue <= root.val
        ) {
            return new ResultType(false, 0, 0);
        }
        
        return new ResultType(true, 
            Math.max(root.val, rightResult.maxValue),
            Math.min(root.val, leftResult.minValue)
        );
    }
}