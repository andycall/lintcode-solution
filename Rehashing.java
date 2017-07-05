/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */    
    public ListNode[] rehashing(ListNode[] hashTable) {
        // write your code here
        if (hashTable == null) {
            return hashTable;
        }
        
        int capacity = hashTable.length;
        ListNode[] newHash = new ListNode[capacity * 2];
        
        for(int i = 0; i < hashTable.length; i ++) {
            if (hashTable[i] != null) {
                ListNode node = hashTable[i];
                
                while (node != null) {
                    int newIndex = (node.val % newHash.length + newHash.length) % newHash.length;
                    
                    if (newHash[newIndex] == null) {
                        newHash[newIndex] = new ListNode(node.val);
                    }
                    else {
                        ListNode dummy = newHash[newIndex];
                        
                        while (dummy.next != null) {
                            dummy = dummy.next;
                        }
                        
                        dummy.next = new ListNode(node.val);
                    }
                    
                    node = node.next;
                }
            }
        }
        
        return newHash;
    }
    
    private int hashCode(int key, int capacity) {
        return (key % capacity + capacity) % capacity;
    }
};
