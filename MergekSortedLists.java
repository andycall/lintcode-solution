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
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {
         // write your code here
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;

        boolean isFinished = false;
        while (!isFinished) {
            isFinished = true;

            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            ListNode minNode = null;

            for(int i = 0; i < lists.size(); i ++ ) {
                ListNode tmpNode = lists.get(i);
                if (tmpNode != null) {
                    isFinished = false;

                    if (tmpNode.val <= min) {
                        min = tmpNode.val;
                        minNode = tmpNode.next;
                        minIndex = i;
                    }
                }
            }

            if (!isFinished) {
                node.next = new ListNode(min);
                node = node.next;
                lists.set(minIndex, minNode);
            }
        }

        return dummy.next;
    }
}
