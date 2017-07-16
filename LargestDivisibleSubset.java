public class Solution {
    /**
     * @param nums a set of distinct positive integers
     * @return the largest subset 
     */
    public List<Integer> largestDivisibleSubset(int[] nums) {
        // Write your code here
        List<Integer> result = new ArrayList<>();
        
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        Arrays.sort(nums);
        int len = nums.length;
        
        int[] dp = new int[len];
        int[] parent = new int[len];
        
        int max = 0;
        int max_index = 0;
        
        for(int i = len - 1; i >= 0; i --) {
            for(int j = i; j < len; j ++) {
                if (nums[j] % nums[i] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                    
                    if (max < dp[i]) {
                        max = dp[i];
                        max_index = i;
                    }
                }
            }
        }
        
        for(int i = 0; i < max; i ++) {
            result.add(nums[max_index]);
            max_index = parent[max_index];
        }
        
        return result;
    }
}