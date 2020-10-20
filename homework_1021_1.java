import java.util.*;
public class homework_1021_1 {
    public static void main(String [] args) {
        System.out.print("Pls enter a number:");
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        reverse(number);
        input.close();
    }
    public static void reverse(int number) {
        while (number != 0) {
            int temp = number % 10;
            System.out.print(temp);
            number /= 10;
        }
    }
}
