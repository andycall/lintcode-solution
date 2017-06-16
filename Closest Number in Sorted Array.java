public class Solution {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int closestNumber(int[] A, int target) {
        // Write your code here
        if (A == null || A.length == 0) {
            return -1;
        }
        
        int start = 0;
        int end = A.length - 1;
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            
            if (target == A[mid]) {
                return mid;
            }
            else if (target < A[mid]) {
                end = mid;
            }
            else if (target > A[mid]) {
                start = mid;
            }
        }
        
        int startDis = Math.abs(A[start] - target);
        int endDis = Math.abs(A[end] - target);
        
        return startDis > endDis ? end : start;
    }
}