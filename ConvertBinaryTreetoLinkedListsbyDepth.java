/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param root the root of binary tree
     * @return a lists of linked list
     */
    public List<ListNode> binaryTreeToLists(TreeNode root) {
        // Write your code here
        List<ListNode> results = new ArrayList<ListNode>();

        if (root == null) {
            return results;
        }

        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            ListNode dummy = new ListNode(0);
            ListNode head = null;
            int size = queue.size();

            for (int i = 0; i < size; i ++) {
                TreeNode node = queue.poll();
                
                if (head == null) {
                    head = new ListNode(node.val);
                    dummy.next = head;
                }
                else {
                    head.next = new ListNode(node.val);
                    head = head.next;
                }
                
                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            results.add(dummy.next);
        }

        return results;
    }
}