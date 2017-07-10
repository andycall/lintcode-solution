/**
 * http://www.lintcode.com/en/problem/unique-paths/
 */

public class Solution {
    /**
     * @param n, m: positive integer (1 <= n ,m <= 100)
     * @return an integer
     */
    public int uniquePaths(int m, int n) {
        // write your code here 
        int[][] paths = new int[n][m];
        
        // 初始化 x 轴
        for(int i = 0; i < m; i ++) {
            paths[0][i] = 1;
        }
        
        for(int i = 0; i < n; i ++) {
            paths[i][0] = 1;
        }
        
        for(int i = 1; i < n; i ++) {
            for(int j = 1; j < m; j ++) {
                paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
            }
        }
        
        return paths[n - 1][m - 1];
    }
}
