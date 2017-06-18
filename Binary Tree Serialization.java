
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
 */
import java.util.*;

class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
class BinaryTreeSerialization {
   /**
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        if (root == null) {
            return "{}";
        }

        // write your code here
        ArrayList<String> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode newNode = queue.poll();
            
            if (newNode == null) {
                list.add("#");
                continue;
            }
            else {
                list.add(Integer.toString(newNode.val));
            }

            queue.add(newNode.left);
            queue.add(newNode.right);
        }

        while (list.get(list.size() - 1).equals("#")) {
            list.remove(list.size() - 1);
        }

        String result = "";
        result += "{";

        for (int i = 0; i < list.size(); i++) {
            if (i + 1 == list.size()) {
                result += list.get(i);
            } else {
                result += list.get(i) + ",";
            }
        }

        result += "}";

        return result;
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
        if (data.equals("{}")) {
            return null;
        }

        String[] strArr = data.substring(1, data.length() - 1).split(",");
        TreeNode head = new TreeNode(Integer.parseInt(strArr[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(head);

        int i = 1;
        while (i < strArr.length) {
            TreeNode tmp = queue.poll();

            if (!strArr[i].equals("#")) {
                int val = Integer.parseInt(strArr[i]);
                TreeNode newNode = new TreeNode(val);
                tmp.left = newNode;
                queue.offer(newNode);
            }
            i++;

            if (i < strArr.length && !strArr[i].equals("#")) {
                int val = Integer.parseInt(strArr[i]);
                TreeNode newNode = new TreeNode(val);
                tmp.right = newNode;
                queue.offer(newNode);
            }
            i++;
        }

        return head;
    }

    public static void main(String[] args) {
        BinaryTreeSerialization binaryTreeSerialization = new BinaryTreeSerialization();

        TreeNode node = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        TreeNode node5 = new TreeNode(6);

        node.left = node1;
        node.right = node2;

        node2.left = node3;
        node2.right = node4;

        String result = binaryTreeSerialization.serialize(node);

        TreeNode root = binaryTreeSerialization.deserialize(result);

        System.out.println(binaryTreeSerialization.serialize(root));
    }
}
