public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        List<List<Integer>> results = new ArrayList<>();
        if (candidates == null) {
            return results;
        }
        
        candidates = removeDuplicate(candidates);
        
        List<Integer> partition = new ArrayList<Integer>();
        
        helper(candidates, 0, target, partition, results);
        
        return results;
    }
    
    private int[] removeDuplicate(int[] sum) {
        Arrays.sort(sum);
        int index = 0;
        for(int i = 0; i < sum.length; i ++) {
            if (sum[i] != sum[index]) {
                sum[++index] = sum[i];
            }
        }
        
        int[] newArray = new int[index + 1];
        
        for(int i = 0; i < newArray.length; i ++) {
            newArray[i] = sum[i];
        }
        
        return newArray;
    }

    private void helper(
            int[] candidates,
            int startIndex,
            int target,
            List<Integer> partition,
            List<List<Integer>> results
        ) {
            if (target == 0) {
                results.add(new ArrayList<Integer>(partition));
                return;
            }
            
            for(int i = startIndex; i < candidates.length; i ++) {
                if (target < candidates[i]) {
                  break;
                }
                
                partition.add(candidates[i]);
                helper(candidates, i, target - candidates[i], partition, results);
                partition.remove(partition.size() - 1);
            }
        }
}