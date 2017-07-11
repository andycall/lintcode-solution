/**
 * http://www.lintcode.com/en/problem/triangle/#
 */
public class Solution {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public int minimumTotal(int[][] triangle) {
        // write your code here
        if (triangle == null || triangle[0] == null || triangle.length == 0 || triangle[0].length == 0) {
            return -1;
        }
        
        int n = triangle.length;
        int[][] paths = new int[n][n];
        
        paths[0][0] = triangle[0][0];
        for(int i = 1; i < n; i ++) {
            paths[i][0] = paths[i - 1][0] + triangle[i][0];
            paths[i][i] = paths[i - 1][i - 1] + triangle[i][i];
        }
        
        for(int i = 1; i < n; i ++) {
            for(int j = 1; j < i; j ++) {
                paths[i][j] = Math.min(paths[i - 1][j], paths[i - 1][j - 1]) + triangle[i][j];
            }
        }
        
        int sum = paths[n - 1][0];
        for(int i = 1; i < n; i ++) {
            sum = Math.min(paths[n - 1][i], sum);
        }
        
        return sum;
    }
}
