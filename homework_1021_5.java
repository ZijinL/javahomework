import java.util.*;
public class homework_1021_5 {
    public static void main(String [] args) {
        double test [][] = {{1,2,3,4}, {1,2,3,4}, {4,3,2,1}, {2,3,4,3}};
        System.out.println(sumMajorDiagonal(test));
    }
    public static double sumMajorDiagonal (double[][]m) {
        double sum = 0;
        for (int i = 0; i < m.length; i++) {
            sum += m[i][i];
        }
        return sum;
    }
}