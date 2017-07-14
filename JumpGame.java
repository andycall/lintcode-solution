public class Solution {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
    public boolean canJump(int[] A) {
        // wirte your code here
        if (A == null || A.length == 0) {
            return false;
        }
        
        int[] paths = new int[A.length];
        paths[0] = A[0];
        
        int fast = paths[0];
        
        for(int i = 1; i < A.length; i ++) {
            if (i <= fast && i + A[i] > fast) {
                fast = A[i] + i;
            }
        }
        
        return fast >= A.length - 1;
    }
}
