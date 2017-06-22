public class Solution {
    private int EMPTY = 0;
    private int HOUSE = 1;
    private int WALL = 2;

    private int[] directionX = {1, 0, -1, 0};
    private int[] directionY = {0, -1, 0, 1};

    private int col;
    private int row;
    private int[][] grid;

    private class Coodinate {
        int x;
        int y;

        public Coodinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private void setGrid(int[][] grid) {
        this.grid = grid;
        this.row = grid.length;
        this.col = grid[0].length;
    }

    private boolean isInBound(Coodinate point) {
        if (point.x < 0 || point.y < 0 || point.x >= this.row || point.y >= this.col) {
            return false;
        }

        return this.grid[point.x][point.y] == EMPTY;
    }

    /**
     * @param grid a 2D grid
     * @return an integer
     */
    public int shortestDistance(int[][] grid) {
        // Write your code here

        // get all house position

        // walk through the map with every house position, save the sum of total distance
        // and the reached count of the point

        // find the minimum sum of total distance and make sure the reached count of the
        // point is equal to house count

        if (grid == null || grid[0] == null) {
            return -1;
        }

        this.setGrid(grid);

        int[][] totalDistanceSum = new int[row][col];
        int[][] reachCount = new int[row][col];

        ArrayList<Coodinate> houseList = this.getCoodinates(grid, HOUSE);

        for (Coodinate point : houseList) {
            this.walkThrough(grid, point, totalDistanceSum, reachCount);
        }

        int shortest = Integer.MAX_VALUE;
        ArrayList<Coodinate> emptys = this.getCoodinates(grid, EMPTY);

        for (Coodinate empty : emptys) {
            if (reachCount[empty.x][empty.y] != houseList.size()) {
                continue;
            }

            shortest = Math.min(shortest, totalDistanceSum[empty.x][empty.y]);
        }

        if (shortest == Integer.MAX_VALUE) {
            return -1;
        }

        return shortest;
    }

    private ArrayList<Coodinate> getCoodinates(int[][] grid, int type) {
        ArrayList<Coodinate> results = new ArrayList<>();

        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                if (grid[i][j] == type) {
                    results.add(new Coodinate(i, j));
                }
            }
        }

        return results;
    }

    private void walkThrough(int[][] grid,
                             Coodinate start,
                             int[][] totalDistanceSum,
                             int[][] reachCount
    ) {
        Queue<Coodinate> queue = new LinkedList<>();
        boolean[][] map = new boolean[this.row][this.col];

        queue.offer(start);
        int steps = 0;

        map[start.x][start.y] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            steps++;

            for (int i = 0; i < size; i++) {
                Coodinate point = queue.poll();

                for (int j = 0; j < 4; j++) {
                    Coodinate newPoint = new Coodinate(
                            point.x + directionX[j],
                            point.y + directionY[j]
                    );

                    if (!this.isInBound(newPoint)) {
                        continue;
                    }

                    if (map[newPoint.x][newPoint.y]) {
                        continue;
                    }

                    map[newPoint.x][newPoint.y] = true;
                    totalDistanceSum[newPoint.x][newPoint.y] += steps;
                    reachCount[newPoint.x][newPoint.y]++;
                    queue.offer(newPoint);
                }
            }
        }
    }
}