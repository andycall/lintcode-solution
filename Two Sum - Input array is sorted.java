public class Solution {
    /*
     * @param nums an array of Integer
     * @param target = nums[index1] + nums[index2]
     * @return [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        
        // write your code here
        int start = 0;
        int end = nums.length - 1;
        
        while (start < end) {
            int sum = nums[start] + nums[end];
            
            if (sum == target) {
                int[] pari = new int[2];
                pari[0] = start + 1;
                pari[1] = end + 1;
                
                return pari;
            }
            else if (sum > target) {
                end--;
            }
            else {
                start++;
            }
        }
        
        return null;
    }
}