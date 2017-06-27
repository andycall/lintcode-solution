/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
     /**
     * @param head a ListNode
     * @param k an integer
     * @return a ListNode
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        head = dummy;
        while (true) {
            head = reverseK(head, k);

            if (head == null) {
                break;
            }
        }

        return dummy.next;
    }

    private ListNode reverseK(ListNode head, int k) {
        ListNode nk = head;

        for(int i = 0; i < k; i ++) {
            if (nk == null) {
                return null;
            }

            nk = nk.next;
        }

        if (nk == null) {
            return null;
        }

        ListNode curt = head.next;
        ListNode n1 = head.next;
        ListNode prev = null;
        ListNode nkplus = nk.next;

        while (curt != nkplus) {
            ListNode tmp = curt.next;
            curt.next = prev;
            prev = curt;
            curt = tmp;
        }

        head.next = nk;
        n1.next = nkplus;

        return n1;
    }
}