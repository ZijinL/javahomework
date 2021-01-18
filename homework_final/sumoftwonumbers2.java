import java.util.Scanner;
import java.util.HashMap;

public class sumoftwonumbers2 {

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

    public static void twosum(int[] nums, int target) {
        int length = nums.length;
        HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
        for (int i = 0; i < length; i++) {
            if (!hashmap.containsKey(target - nums[i])) {
                hashmap.put(nums[i], i);
            }
            else {
                System.out.print(hashmap.get(target - nums[i]));
                System.out.print(" ");
                System.out.print(i);
            }
        }
    }
}