import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class isSubtree {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n_1 = input.nextInt();
        int[] nums_1 = new int[n_1];
        for (int i = 0; i < n_1; i++) {
            nums_1[i] = input.nextInt();
        }
        int n_2 = input.nextInt();
        int[] nums_2 = new int[n_2];
        for (int i = 0; i < n_2; i++) {
            nums_2[i] = input.nextInt();
        }
        input.close();
        TreeNode tree_1 = genTree(nums_1);
        TreeNode tree_2 = genTree(nums_2);
        System.out.print(compTree(tree_1, tree_2));
    }

    public static boolean compTree(TreeNode root_1, TreeNode root_2) {
        if (root_2 == null || root_1 == null)
            return false;
        else if (compNode(root_1, root_2))
            return true;
        else
            return compTree(root_1.left, root_2) || compTree(root_1.right, root_2);
    }

    public static boolean compNode(TreeNode node_1, TreeNode node_2) {
        if (node_2 == null)
            return true;
        else if (node_1 == null || node_1.val != node_2.val)
            return false;
        else
            return compNode(node_1.left, node_2.left) && compNode(node_1.right, node_2.right);
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

    public static void midorder(TreeNode root) {
        if (root == null)
            return;
        if (root.left != null)
            midorder(root.left);
        System.out.print(root.val + " ");
        if (root.right != null)
            midorder(root.right);
    }

    public static void printTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int current = 1;
        int next = 0;
        while (!queue.isEmpty()) {
            System.out.print(queue.peek().val + " ");
            if (queue.peek().left != null) {
                queue.add(queue.peek().left);
                next++;
            }
            if (queue.peek().right != null) {
                queue.add(queue.peek().right);
                next++;
            }
            queue.poll();
            current--;

            if (current == 0) {
                current = next;
                next = 0;
                System.out.println();
            }
        }
    }
}

// class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;

//     TreeNode(int x) {
//         val = x;
//         left = null;
//         right = null;
//     }

//     TreeNode(int x, TreeNode left, TreeNode right) {
//         val = x;
//         this.left = left;
//         this.right = right;
//     }

//     TreeNode() {
//         val = 0;
//         left = null;
//         right = null;
//     }
// }