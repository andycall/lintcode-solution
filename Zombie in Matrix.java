class Coodinate {
    int x, y;
    public Coodinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    private int PEOPLE = 0;
    private int ZOMBIE = 1;
    private int WALL = 2;
    
    public int[] deltaX = {1, 0, 0, -1};
    public int[] deltaY = {0, 1, -1, 0};

    private boolean isPeople(Coodinate position, int[][] grid) {
        if (position.x < 0 || position.y < 0 || position.x >= grid.length || position.y >= grid[0].length) {
            return false;
        }
        
        int point = grid[position.x][position.y];
        return point == 0;
    }
    
    /**
     * @param grid  a 2D integer grid
     * @return an integer
     */
    public int zombie(int[][] grid) {
        // Write your code here
        int people = 0;
        
        int row = grid.length;
        int col = grid[0].length;
        
        Queue<Coodinate> queue = new LinkedList<>();
        
        for(int i = 0; i < row; i ++) {
            for (int j = 0; j < col; j ++) {
                int point = grid[i][j];
                
                switch(point) {
                    case 0:
                        people++;
                        break;
                    case 1:
                        queue.offer(new Coodinate(i, j));
                }
            }
        }
        
        if (people == 0) {
            return 0;
        }
        
        int day = 0;
        while (!queue.isEmpty()) {
            day++;
            int size = queue.size();
            
            for (int i = 0; i < size; i ++) {
                Coodinate zombie = queue.poll();
                for (int j = 0; j < 4; j ++) {
                    Coodinate direction = new Coodinate(
                        zombie.x + this.deltaX[j],
                        zombie.y + this.deltaY[j]
                    );
                    
                    if (!this.isPeople(direction, grid)) {
                        continue;
                    }
                    
                    grid[direction.x][direction.y] = ZOMBIE;
                    people--;
                    
                    if (people == 0) {
                        return day;
                    }
                    
                    queue.offer(direction);
                }
            }
        }
        
        return -1;
    }
}