class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of unique permutations.
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        // Write your code here
        List<List<Integer>> results = new ArrayList<>();
        
        if (nums == null) {
            return results;
        }
        
        if (nums.length == 0) {
            results.add(new ArrayList<Integer>());
            return results;
        }
        
        Arrays.sort(nums);
        helper(0, nums, results);
        
        return results;
    }
    
    private void helper(int i, int[] nums, List<List<Integer>> results) {
        if (i == nums.length - 1) {
            List<Integer> list = new ArrayList<>();
            
            for(int n: nums) {
                list.add(n);
            }
            
            results.add(list);
        }
        else {
            for(int j = i; j < nums.length; j ++) {
                if (j > i && nums[j] == nums[i]) {
                    continue;
                }
                
                swap(nums, i, j);
                helper(i + 1, Arrays.copyOf(nums, nums.length), results);
            }
        }
    }
    
    private void swap(int[] nums, int start, int end) {
        int tmp = nums[start];
        nums[start] = nums[end];
        nums[end] = tmp;
    }
}


