public class Solution {
    /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
     
        int len = nums.length;   
        int[] paths = new int[len];
        
        int max = 0;
        for(int i = 0; i < len; i ++) {
            paths[i] = 1;
            
            for(int j = 0; j < i; j ++) {
                if (nums[i] > nums[j]) {
                    paths[i] = paths[i] > paths[j] + 1 ? paths[i] : paths[j] + 1;
                }
            }
            
            if (max < paths[i]) {
                max = paths[i];
            }
        }
        
        return max;
    }
}
