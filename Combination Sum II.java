public class Solution {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        // write your code here
        List<List<Integer>> results = new ArrayList<>();
        
        if (num == null) {
            return null;
        }
        
        Arrays.sort(num);
        
        List<Integer> partition = new ArrayList<>();
        
        helper(target, 0, num, partition, results);
        
        return results;
    }
    
    private void helper(
        int target,
        int startIndex,
        int[] num,
        List<Integer> partition,
        List<List<Integer>> results
        ) {
        if (target == 0) {
            results.add(new ArrayList<Integer>(partition));
            return;
        }
        
        for(int i = startIndex; i < num.length; i ++) {
            if (i != startIndex && num[i] == num[i - 1]) {
                continue;
            }
             
            if (target < 0) {
                break;
            }
            
            partition.add(num[i]);
            helper(target - num[i], i + 1, num, partition, results);
            partition.remove(partition.size() - 1);
        }
    }
}