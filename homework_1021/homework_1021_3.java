import java.util.*;
public class homework_1021_3 {
    public static void main(String [] args) {
        Random rand = new Random();
        int[] counts = new int[10];
        for (int i = 0; i < 100; i++) {
            int temp = rand.nextInt(10);
            counts[temp] += 1;
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(i + ": " + counts[i]);
        }
    }
}
