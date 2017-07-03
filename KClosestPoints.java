/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    private Point globalOrigin = null;
    /**
     * @param points a list of points
     * @param origin a point
     * @param k an integer
     * @return the k closest points
     */
    public Point[] kClosest(Point[] points, Point origin, int k) {
        // Write your code here
        if (points == null || origin == null) {
            return null;
        }
        
        this.globalOrigin = origin;
        
        PriorityQueue<Point> queue = new PriorityQueue<Point>(k, new Comparator<Point>() {
            @Override
            public int compare(Point a, Point b) {
                int diff = distance(b, globalOrigin) - distance(a, globalOrigin);
                
                if (diff == 0) {
                    diff = b.x - a.x;
                }
                else if (diff == 0) {
                    diff = b.y - a.y;
                }
                
                return diff;
            }
        });
        
        for(int i = 0; i < points.length; i ++) {
            queue.offer(points[i]);
            
            if (queue.size() > k) {
                queue.poll();
            }
        }
        
        k = queue.size();
        Point[] ret = new Point[k];
        while (!queue.isEmpty()) {
            ret[--k] = queue.poll();
        }
        
        return ret;
    }
    
    private int distance(Point a, Point b) {
        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
    }
}