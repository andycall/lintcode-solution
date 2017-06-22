/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // write your code here
        if (node == null) {
            return null;
        }
    
        //use bfs to get all nodes
        ArrayList<UndirectedGraphNode> nodeList = this.getNodes(node);
        HashMap<UndirectedGraphNode, UndirectedGraphNode> hash = new HashMap<>();
        
        // clone node Element
        for(UndirectedGraphNode n : nodeList) {
            hash.put(n, new UndirectedGraphNode(n.label));
        }
        
        // clone neibors
        for(UndirectedGraphNode n : nodeList) {
            UndirectedGraphNode newNode = hash.get(n);
            for(UndirectedGraphNode neibors : n.neighbors) {
                UndirectedGraphNode newNeibor = hash.get(neibors);
                newNode.neighbors.add(newNeibor);
            }
        }

        return hash.get(node);
    }
    
    private ArrayList<UndirectedGraphNode> getNodes(UndirectedGraphNode node) {
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        Set<UndirectedGraphNode> set = new HashSet<UndirectedGraphNode>();
        
        queue.offer(node);
        set.add(node);
        
        while (!queue.isEmpty()) {
            UndirectedGraphNode n = queue.poll();
            for(UndirectedGraphNode nei : n.neighbors) {
                if (!set.contains(nei)) {
                    set.add(nei);
                    queue.offer(nei);
                }
            }
        }
        
        return new ArrayList<UndirectedGraphNode>(set);
    }
}