public class Fibonacci {
    public static void main (String [] args) {
        int n = 1000;
        System.out.println(fibonacci(n));
    }
    public static int fibonacci(int n) {
        int n_0 = 0;
        int n_1 = 1;
        int n_2 = 0;
        for (int i = 2; i <= n; i++) {
            n_2 = n_0 + n_1;
            n_0 = n_1;
            n_1 = n_2;
        }
        return n_2;
    }
}
