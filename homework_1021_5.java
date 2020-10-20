import java.util.*;
public class homework_1021_5 {
    public static void main(String [] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("please enter a 4-by-4 matrix: ");
        double test [][] = new double[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                test[i][j] = input.nextDouble();
            }
        }
        System.out.println("Sum of the elements in the major diagonal is " + sumMajorDiagonal(test));
    }
    public static double sumMajorDiagonal (double[][]m) {
        double sum = 0;
        for (int i = 0; i < m.length; i++) {
            sum += m[i][i];
        }
        return sum;
    }
}