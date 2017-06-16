import java.util.*;

public class Solution {
    private class TreeNode {
        public int val;
        public ArrayList<TreeNode> list;

        public TreeNode(int val) {
            this.val = val;
            this.list = new ArrayList<>();
        }
    }


    /**
     * @param n an integer
     * @param edges a list of undirected edges
     * @return true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        // Write your code here
        if (n <= 0) {
            return false;
        }
        
        if (edges.length != n - 1) {
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        Map<Integer, TreeNode> map = new HashMap<>();

        // build tree
        for (int i = 0; i < edges.length; i ++) {
            for (int j = 0; j < edges[i].length; j ++) {
                int key = edges[i][j];
                if (!map.containsKey(key)) {
                    map.put(key, new TreeNode(key));
                }
            }

            TreeNode preNode = map.get(edges[i][0]);
            TreeNode nextNode = map.get(edges[i][1]);
            preNode.list.add(nextNode);
            nextNode.list.add(preNode);
        }

        Set<TreeNode> hash = new HashSet<>();

        if (map.size() == 0) {
            return true;
        }

        // Find circle
        queue.offer(map.get(0));
        hash.add(map.get(0));
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            for (int i = 0; i < node.list.size(); i ++) {
                if (hash.contains(node.list.get(i))) {
                    continue;
                }
                
                hash.add(node.list.get(i));
                queue.offer(node.list.get(i));
            }
        }

        return (hash.size() == n);
    }
}