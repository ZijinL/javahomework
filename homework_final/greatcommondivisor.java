public class greatcommondivisor {
    public static void main(String[] args) {
        System.out.println(gcd_euclid(100, 36));
    }

    public static int gcd(int m, int n) {
        if (m % n == 0)
            return n;
        for (int i = n / 2; i > 0; i--) {
            if (m % i == 0 && n % i == 0)
                return i;
        }
        return 1;
    }

    public static int gcd_euclid(int m, int n) {
        if (m % n == 0)
            return n;
        else
            return gcd(m, m%n);

    }
}
