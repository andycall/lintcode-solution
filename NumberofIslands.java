public class Solution {
     private class Coordinate {
        private int x;
        private int y;
        private boolean[][] grid;

        public Coordinate(int x, int y, boolean[][] grid) {
            this.x = x;
            this.y = y;
            this.grid = grid;
        }
    }

    boolean isInBound(int x, int y, boolean[][] grid) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
    }

    /**
     * @param grid a boolean 2D matrix
     * @return an integer
     */
    public int numIslands(boolean[][] grid) {
        // Write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int col = grid.length;
        int row = grid[0].length;

        int islands = 0;
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (grid[i][j]) {
                    makeDFSIsland(grid, i, j);
                    islands++;
                }
            }
        }

        return islands;
    }

    private void makeDFSIsland(boolean[][] grid, int i, int j) {
        int[] directionX = {0, 1, 0, -1};
        int[] directionY = {1, 0, -1, 0};

        LinkedList<Coordinate> queue = new LinkedList<Coordinate>();
        queue.offer(new Coordinate(i, j, grid));
        grid[i][j] = false;

        while (!queue.isEmpty()) {
            Coordinate co = queue.poll();

            for (int count = 0; count < 4; count++) {
                int x = directionX[count] + co.x;
                int y = directionY[count] + co.y;
                Coordinate newCo = new Coordinate(x, y, grid);

                if (!isInBound(x, y, grid)) {
                    continue;
                }

                if (grid[x][y]) {
                    grid[x][y] = false;
                    queue.offer(newCo);
                }
            }
        }
    }
}