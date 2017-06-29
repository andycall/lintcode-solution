class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
    public void sortColors(int[] nums) {
       if (nums == null || nums.length <= 1) {
           return;
       }
       
       int start = 0;
       int end = nums.length - 1;
       int i = 0;
       
       while (i <= end) {
           if (nums[i] == 0) {
               swap(nums, start, i);
               start++;
               i++;
           }
           else if (nums[i] == 1) {
               i++;
           }
           else {
               swap(nums, i, end);
               end--;
           }
       }
    }
    
    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

}