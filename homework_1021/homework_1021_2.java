import java.util.*;
public class homework_1021_2 {
    public static void main (String [] args) {
        System.out.print("please enter n: ");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        printMatrix(n);
        input.close();
    }
    public static void printMatrix(int n) {
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(r.nextInt(2) + " ");
            }
            System.out.print("\n");
        }
    }
}
