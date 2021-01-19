import java.util.*;

public class weightedpathlength {
    public static void main(String[] rgs) {
        int[] nums = { 2, 3, 4, 0, 0, 1, 6 };
        ValTreeNode tree = genTree(nums);
        midorder(tree);
        System.out.println(calWeight(tree, 0));
    }

    public static int calWeight(ValTreeNode root, int layer) {
        int res = root.weight * layer;
        if (root.left != null)
            res += calWeight(root.left, layer + 1);
        if (root.right != null)
            res += calWeight(root.right, layer + 1);
        return res;
    }

    public static ValTreeNode genTree(int[] nums) {
        int length = nums.length;
        Queue<ValTreeNode> queue = new LinkedList<ValTreeNode>();
        ValTreeNode root = new ValTreeNode(nums[0]);
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty()) {
            if (i < length && nums[i] != 0) {
                queue.peek().left = new ValTreeNode(nums[i]);
                queue.add(queue.peek().left);
            }
            if (i + 1 < length && nums[i + 1] != 0) {
                queue.peek().right = new ValTreeNode(nums[i + 1]);
                queue.add(queue.peek().right);
            }
            queue.poll();
            i += 2;
        }
        return root;
    }

    public static void midorder(ValTreeNode root) {
        if (root == null)
            return;
        midorder(root.left);
        System.out.print(root.weight + " ");
        midorder(root.right);
    }

}

class ValTreeNode {
    int weight;
    ValTreeNode left;
    ValTreeNode right;

    ValTreeNode(int x) {
        weight = x;
    }
}
