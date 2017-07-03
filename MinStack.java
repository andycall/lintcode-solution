public class MinStack {
    private class ListNode {
        int val;

        ListNode next;
        ListNode prev;

        ListNode(int val) {
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }

    private ListNode min;
    private ListNode head;
    private ListNode dummy;
    private Stack<ListNode> minStack;

    public MinStack() {
        // do initialize if necessary
        this.dummy = new ListNode(Integer.MAX_VALUE);
        this.head = dummy;
        this.minStack = new Stack<>();
        this.minStack.push(dummy);
        min = dummy;
    }

    public void push(int number) {
        // write your code here
        ListNode newNode = new ListNode(number);
        head.next = newNode;
        newNode.prev = head;
        head = newNode;

        if (newNode.val < this.min.val) {
            this.minStack.push(newNode);
            this.min = newNode;
        }
    }

    public int pop() {
        if (this.head == this.dummy) {
            return -1;
        }

        ListNode popNode = head;
        head = head.prev;

        if (this.min == popNode) {
            this.minStack.pop();
            this.min = this.minStack.peek();
        }

        return popNode.val;
    }

    public int min() {
        if (this.min == this.dummy) {
            return -1;
        }

        return this.min.val;
    }
}
