import java.util.Scanner;
public class lackNumber {
    public static void main (String [] args) {
        Scanner input = new Scanner(System.in);
        int length = input.nextInt();
        int [] nums = new int[length];
        for (int i = 0; i < length; i++) {
            nums[i] = input.nextInt();
        }
        input.close();
        System.out.print(getlackNumber(length, nums));
    }

    public static int getlackNumber(int length, int [] nums) {
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum = nums[i] - i;
            if (sum != 0) return i;
        }
        return length;
    }

}
