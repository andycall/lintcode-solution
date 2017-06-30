public class Solution {
    /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        // write your code here
        if (numbers == null || numbers.length < 3) {
            return list;    
        }
        
        Arrays.sort(numbers);
        for(int i = 0; i < numbers.length - 2; i ++) {
            if (i > 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            
            int target = -numbers[i];
            int left = i + 1;
            int right = numbers.length - 1;
            
            twoSum(numbers, target, left, right, list);
        }
        
        return list;
    }
    
    private void twoSum(int[] nums, int target, int left, int right, ArrayList<ArrayList<Integer>> list) {
        if (left >= right) {
            return;
        }
        
        while (left < right) {
            int sum = nums[left] + nums[right];
            
            if (sum == target) {
                ArrayList<Integer> result = new ArrayList<>();
                result.add(-target);
                result.add(nums[left]);
                result.add(nums[right]);
                list.add(result);
                
                left++;
                right--;
                
                while (left < right && nums[left] == nums[left - 1]) {
                    left++;
                }
                
                while (left < right && nums[right] == nums[right + 1]) {
                    right--;
                }
            }
            else if (sum < target) {
                left++;
            }
            else {
                right--;
            }
        }
    }
}