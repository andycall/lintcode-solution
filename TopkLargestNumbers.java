class Solution {
    /*
     * @param nums an integer array
     * @param k an integer
     * @return the top k largest numbers in array
     */
    public int[] topk(int[] nums, int k) {
        // Write your code here
        if (nums == null) {
            return null;
        }
        
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer pre, Integer nex) {
                return pre - nex;
            }
        });
        
        for(int i = 0; i < nums.length; i ++) {
            queue.offer(nums[i]);
            
            if (queue.size() > k) {
                queue.poll();
            }
        }
        
        int[] ret = new int[k];
        while (!queue.isEmpty()) {
            ret[--k] = queue.poll();
        }
        
        return ret;
    }
};

