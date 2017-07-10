public class LRUCache {
    private class ListNode {
        int val;
        int key;
        
        ListNode prev;
        ListNode next;
        
        public ListNode(int val, int key) {
            this.val = val;
            this.key = key;
        }
    }
    
    private Map<Integer, ListNode> map = new HashMap<>();
    private ListNode head = new ListNode(-1, -1);
    private ListNode tail = new ListNode(-1, -1);
    private int size;
    
    // @param capacity, an integer
    public LRUCache(int capacity) {
        // write your code here
        this.size = capacity;
        
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    // @return an integer
    public int get(int key) {
        // write your code here
        if (!map.containsKey(key)) {
            return -1;
        }
        
        ListNode current = map.get(key);
        current.prev.next = current.next;
        current.next.prev = current.prev;
        moveToTail(current);
        
        return current.val;
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        // write your code here
        if (this.get(key) != -1) {
            this.map.get(key).val = value;
            return;
        }
        
        if (this.map.size() == size) {
            this.map.remove(this.head.next.key);
            this.head.next = this.head.next.next;
            this.head.next.prev = this.head;
        }
        
        ListNode newNode = new ListNode(value, key);
        this.map.put(key, newNode);
        moveToTail(newNode);
    }
    
    private void moveToTail(ListNode current) {
        this.tail.prev.next = current;
        current.prev = this.tail.prev;
        current.next = this.tail;
        this.tail.prev = current;
    }
}