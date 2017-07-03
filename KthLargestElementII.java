class Solution {
    /**
     * @param nums an integer unsorted array
     * @param k an integer from 1 to n
     * @return the kth largest element
     */
    public int kthLargestElement2(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for(int num : nums) {
            queue.offer(num);
            
            if (queue.size() > k) {
                queue.poll();
            }
        }
        
        return queue.peek();
    }
};