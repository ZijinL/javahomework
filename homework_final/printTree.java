import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class printTree {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int length = input.nextInt();
        int[] nums = new int[length];
        for (int i = 0; i < length; i++) {
            nums[i] = input.nextInt();
        }
        input.close();
        TreeNode tree = genTree(nums);
        layerorder2(tree);
    }

    public static void midorder(TreeNode root) {
        if (root == null)
            return;
        midorder(root.left);
        System.out.print(root.val + " ");
        midorder(root.right);
    }

    public static void layerorder(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        if (root == null)
            return;
        queue.add(root);
        while (!queue.isEmpty()) {
            System.out.print(queue.peek().val + " ");
            if (queue.peek().left != null)
                queue.add(queue.peek().left);
            if (queue.peek().right != null)
                queue.add(queue.peek().right);
            queue.pop();
        }
    }

    public static void layerorder2(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        if (root == null)
            return;
        queue.add(root);
        int currentline = 1;
        int nextline = 0;
        while (!queue.isEmpty()) {
            System.out.print(queue.peek().val + " ");
            if (queue.peek().left != null) {
                queue.add(queue.peek().left);
                nextline += 1;
            }
            if (queue.peek().right != null) {
                queue.add(queue.peek().right);
                nextline += 1;
            }
            queue.pop();
            currentline -= 1;
            if (currentline == 0) {
                currentline = nextline;
                nextline = 0;
                System.out.println();
            }
        }
    }

    public static TreeNode genTree(int[] nums) {
        int length = nums.length;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode root = new TreeNode(nums[0]);
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty()) {
            if (i < length && nums[i] != 0) {
                queue.peek().left = new TreeNode(nums[i]);
                queue.add(queue.peek().left);
            }
            if (i + 1 < length && nums[i + 1] != 0) {
                queue.peek().right = new TreeNode(nums[i + 1]);
                queue.add(queue.peek().right);
            }
            queue.poll();
            i += 2;
        }
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}