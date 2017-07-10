/**
 * http://www.lintcode.com/en/problem/climbing-stairs/#
 */
public class Solution {
    /**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        // write your code here
        if (n < 0) {
            return 0;
        }
        
        if (n < 2) {
            return 1;
        }
        
        int[] steps = new int[n];
        steps[0] = 1;
        steps[1] = 2;
        
        for(int i = 2; i < n; i ++) {
            steps[i] = steps[i - 1] + steps[i - 2];
        }
        
        return steps[n - 1];
    }
}