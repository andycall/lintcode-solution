class Solution {
   public List<List<Integer>> permute(int[] nums) {
        // write your code here
        ArrayList<List<Integer>> results = new ArrayList<List<Integer>>();

        if (nums == null) {
            return results;
        }

        if (nums.length == 0) {
            results.add(new ArrayList<Integer>());
            return results;
        }

        helper(new ArrayList<Integer>(), nums, results);

        return results;
    }

    private void helper(ArrayList<Integer> sets, int[] nums, ArrayList<List<Integer>> results) {
        if (sets.size() == nums.length) {
            results.add(new ArrayList<Integer>(sets));
            return;
        }

        for(int i = 0; i < nums.length; i ++) {
            if (sets.contains(nums[i])) {
                continue;
            }

            sets.add(nums[i]);
            helper(new ArrayList<Integer>(sets), nums, results);
            sets.remove(sets.size() - 1);
        }
    }
}