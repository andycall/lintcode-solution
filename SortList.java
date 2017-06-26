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
     * @param head: The head of linked list.
     * @return: You should return the head of the sorted linked list,
                    using constant space complexity.
     */
    public ListNode sortList(ListNode head) {  
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode middle = findMiddle(head);
        
        ListNode leftDummy = new ListNode(0);
        ListNode leftPointer = leftDummy;
        
        ListNode middleDummy = new ListNode(0);
        ListNode middlePointer = middleDummy;
        
        ListNode rightDummy = new ListNode(0);
        ListNode rightPointer = rightDummy;
        
        while (head != null) {
            if (head.val < middle.val) {
                leftPointer.next = head;
                leftPointer = head;
            } else if (head.val > middle.val) {
                rightPointer.next = head;
                rightPointer = head;
            } else {
                middlePointer.next = head;
                middlePointer = head;
            }
            
            head = head.next;
        }
        
        leftPointer.next = null;
        rightPointer.next = null;
        middlePointer.next = null;
        
        ListNode left = sortList(leftDummy.next);
        ListNode right = sortList(rightDummy.next);
        
        return concat(left, middleDummy.next, right);
    }
    
    private ListNode concat(ListNode left, ListNode middle, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        
        tail.next = left;
        tail = getTail(tail);
        
        tail.next = middle;
        tail = getTail(tail);
        
        tail.next = right;
        tail = getTail(tail);
        
        return dummy.next;
    }
    
    private ListNode getTail(ListNode head) {
        if (head == null) {
            return head;
        }
        
        while (head.next != null) {
            head = head.next;
        }
        
        return head;
    }
    
    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
}
