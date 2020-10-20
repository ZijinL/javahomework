import java.util.*;
public class homework_1021_4 {
    public static void main(String [] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter 10 integers: ");
        double[] temp = new double[10];
        for (int i = 0; i < 10; i++) {
            temp [i] = input.nextInt();
        }
        System.out.println(indexofSmallestElement(temp));
        input.close();
    }
    public static int indexofSmallestElement(double[]array) {
        int min_index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < array[min_index]) {
                min_index = i;
            }
        }
        return min_index;
    }
}
