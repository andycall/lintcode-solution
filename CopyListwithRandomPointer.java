/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        if (head == null) {
            return null;
        }
        
        RandomListNode dummy = new RandomListNode(0);
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        
        RandomListNode prev = dummy;
        RandomListNode newNode;
        
        while (head != null) {
            if (map.containsKey(head)) {
                newNode = map.get(head);                
            } else {
                newNode = new RandomListNode(head.label);
                map.put(head, newNode);
            }
            
            prev.next = newNode;
            
            if (head.random != null) {
                if (map.containsKey(head.random)) {
                    newNode.random = map.get(head.random);
                } else {
                    newNode.random = new RandomListNode(head.random.label);
                    map.put(head.random, newNode.random);
                }
            }
            
            prev = newNode;
            head = head.next;
        }
        
        return dummy.next;
    }
}