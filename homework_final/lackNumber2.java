import java.util.Scanner;

public class lackNumber2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int length = input.nextInt();
        int[] nums = new int[length];
        for (int i = 0; i < length; i++) {
            nums[i] = input.nextInt();
        }
        input.close();
        System.out.print(getlackNumber(0, length, nums));
    }

    // 这里用左闭右开的区间，从而统一了尾部元素的情况
    public static int getlackNumber(int start, int end, int[] nums) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] == mid) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

}
