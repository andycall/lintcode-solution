public class Solution {
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int start = 0;
        int end = nums.length - 1;
        int target = nums[nums.length - 1];
        
        while (start + 1 < end) {
            int middle = start + (end - start) / 2;
            
            if (nums[middle] <= target) {
                end = middle;
            }
            else {
                start = middle;
            }
        }
        
        if (nums[start] <= nums[end]) {
            return nums[start];
        }
        return nums[end];
    }
}