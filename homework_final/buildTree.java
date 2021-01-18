import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class buildTree {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int length = input.nextInt();
        ArrayList<Integer> nums_pre = new ArrayList<Integer>();
        for (int i = 0; i < length; i++) {
            nums_pre.add(input.nextInt());
        }
        ArrayList<Integer> nums_mid = new ArrayList<Integer>();
        for (int i = 0; i < length; i++) {
            nums_mid.add(input.nextInt());
        }
        input.close();
        TreeNode root = genTree(nums_pre, nums_mid);
        postorder(root);

    }

    public static void postorder(TreeNode root) {
        if (root == null)
            return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val + " ");

    }

    public static TreeNode genTree(List<Integer> nums_pre, List<Integer> nums_mid) {
        if (nums_mid.isEmpty())
            return null;
        int rootVal = nums_pre.remove(0);
        int rootIndex = nums_mid.indexOf(rootVal);

        TreeNode root = new TreeNode(rootVal);
        root.left = genTree(nums_pre, nums_mid.subList(0, rootIndex));
        root.right = genTree(nums_pre, nums_mid.subList(rootIndex + 1, nums_mid.size()));

        return root;
    }




}

// class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;

//     TreeNode(int x) {
//         val = x;
//     }
// }
