import java.util.Scanner;

public class sumoftwonumbers {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int length = input.nextInt();
        int[] nums = new int[length];
        for (int i = 0; i < length; i++) {
            nums[i] = input.nextInt();
        }
        int target = input.nextInt();
        input.close();
        twosum(nums, target);
    }

    public static int[] twosum(int[] nums, int target) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] + nums[j] == target) {
                    System.out.print(i + " ");
                    System.out.print(j);
                }
            }
        }
        return null;
    }
}