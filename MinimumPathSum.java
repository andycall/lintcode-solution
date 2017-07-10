/**
 *  http://www.lintcode.com/en/problem/minimum-path-sum/
 */
public class Solution {
    /**
     * @param grid: a list of lists of integers.
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    public int minPathSum(int[][] grid) {
        // write your code here
        if (grid == null || grid[0].length == 0) {
            return 0;
        }
        
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] paths = new int[m][n];
        paths[0][0] = grid[0][0];
        
        // 初始化x轴
        for(int i = 1; i < n; i ++) {
            paths[0][i] = paths[0][i - 1] + grid[0][i];
        }
        
        // 初始化y轴
        for(int i = 1; i < m; i ++) {
            paths[i][0] = paths[i - 1][0] + grid[i][0];
        }
        
        for(int i = 1; i < m; i ++) {
            for(int j = 1; j < n; j ++) {
                paths[i][j] = Math.min(paths[i - 1][j], paths[i][j - 1]) + grid[i][j]; 
            }
        }
        
        return paths[m - 1][n - 1];
    }
}
