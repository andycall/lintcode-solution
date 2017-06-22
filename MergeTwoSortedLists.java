/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param ListNode l1 is the head of the linked list
     * @param ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here
        ListNode dummy = new ListNode(0);
        ListNode last = dummy;
        
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                last.next = l1;
                l1 = l1.next;
            }
            else {
                last.next = l2;
                l2 = l2.next;
            }
            last = last.next;
        }
        
        if (l1 != null) {
            last.next = l1;
        }
        else if (l2 != null) {
            last.next = l2;
        }
        
        return dummy.next;
    }
}