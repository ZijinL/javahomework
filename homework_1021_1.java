import java.util.Scanner;
public class homework_1021_1 {
    public static void main(String [] args) {
        System.out.print("Pls enter a number:");
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        reverse(number);
        input.close();
    }
    public static void reverse(int number) {
        if (number == 0) {
            System.out.print(number);
            return;
        }
        while (number % 10 == 0) {
            number /= 10;
        }
        while (number > 0) {
            System.out.print(number % 10);
            number /= 10;
        }
    }
}
