import java.util.Scanner;
import java.util.Stack;

public class validateStackSequences {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int length = input.nextInt();
        int[] pushed = new int[length];
        for (int i = 0; i < length; i++) {
            pushed[i] = input.nextInt();
        }
        int[] poped = new int[length];
        for (int i = 0; i < length; i++) {
            poped[i] = input.nextInt();
        }
        input.close();
        if (sequenceVerify(length, pushed, poped))
            System.out.println("true");
        else
            System.out.println("false");

    }

    public static boolean sequenceVerify(int length, int[] pushed, int[] poped) {
        Stack<Integer> stk = new Stack<Integer>();
        int j = 0;
        for (int i = 0; i < length; i++) {
            stk.push(pushed[i]);
            while (!stk.empty() && stk.peek() == poped[j]) {
                stk.pop();
                j++;
            }
        }
        return j == length;
    }
}