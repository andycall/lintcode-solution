import java.util.*;

public class SubarraySum {
     /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySum(int[] nums) {
        // write your code here
        ArrayList<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        int sum = 0;

        map.put(0, -1);

        for(int i = 0; i < nums.length; i ++) {
            sum += nums[i];

            if (map.containsKey(sum)) {
                list.add(map.get(sum) + 1);
                list.add(i);
                return list;
            }

            map.put(sum, i);
        }

        return list;
    }
}