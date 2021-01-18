import java.util.LinkedList;

public class commonAncester {
    static TreeNode ans = null;
    public static void main(String[] args) {
        int[] nums = { 3, 5, 1, 6, 2, 0, 8, Integer.MAX_VALUE, Integer.MAX_VALUE, 7, 4 };
        TreeNode[] init_tree = genTree(nums, 5, 1);
        TreeNode root = init_tree[0];
        TreeNode p = init_tree[1];
        TreeNode q = init_tree[2];
        System.out.print(lowestCommonAncestor(root, p, q).val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }

    public static boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null)
            return false;
        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);
        if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson)))
            ans = root;
        return root.val == p.val || root.val == q.val || lson || rson;
    }

    public static void midorder(TreeNode root) {
        if (root == null)
            return;
        midorder(root.left);
        System.out.print(root.val + " ");
        midorder(root.right);
    }

    public static TreeNode[] genTree(int[] nums, int p_value, int q_value) {
        int length = nums.length;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode root = new TreeNode(nums[0]);
        TreeNode p = null, q = null;
        queue.add(root);
        int cur = 1;
        while (!queue.isEmpty()) {
            if (cur < length && nums[cur] != Integer.MAX_VALUE) {
                queue.peek().left = new TreeNode(nums[cur]);
                queue.add(queue.peek().left);
                if (nums[cur] == p_value)
                    p = queue.peek().left;
                if (nums[cur] == q_value)
                    q = queue.peek().left;
            }
            if (cur + 1 < length && nums[cur + 1] != Integer.MAX_VALUE) {
                queue.peek().right = new TreeNode(nums[cur + 1]);
                queue.add(queue.peek().right);
                if (nums[cur + 1] == p_value)
                    p = queue.peek().right;
                if (nums[cur + 1] == q_value)
                    q = queue.peek().right;
            }
            queue.poll();
            cur += 2;
        }
        TreeNode[] res = { root, p, q };
        return res;
    }
}
