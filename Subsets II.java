class Solution {
    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        
        if (nums == null) {
            return results;
        }
        
        if (nums.length == 0) {
            results.add(new ArrayList<Integer>());
            return results;
        }
        
        Arrays.sort(nums);
        
        ArrayList<Integer> subsets = new ArrayList<>();
        
        helper(subsets, 0, nums, results);
        
        return results;
    }
    
    private void helper(ArrayList<Integer> subsets, int startIndex, int[] nums, ArrayList<ArrayList<Integer>> results) {
        results.add(new ArrayList<Integer>(subsets));
        
        for(int i = startIndex; i < nums.length; i ++) {
            if (i != startIndex && nums[i] == nums[i - 1]) {
                continue;
            }
            subsets.add(nums[i]);
            helper(subsets, i + 1, nums, results);
            subsets.remove(subsets.size() - 1);
        }
    }
    //  public void helper(int[] nums, int startIndex, ArrayList<Integer> subset, ArrayList<ArrayList<Integer>> results){
    //     results.add(new ArrayList<Integer>(subset));
    //     for(int i=startIndex; i<nums.length; i++){
    //         if (i != startIndex && nums[i]==nums[i-1]) {
    //             continue;
    //         }
    //         subset.add(nums[i]);
    //         helper(nums, i+1, subset, results);
    //         subset.remove(subset.size()-1);
    //     }
    // }
}
