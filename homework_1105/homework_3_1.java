import java.util.Date;
public class homework_3_1 {
    public static void main (String[] args) {
        Date date = new Date();
        long millisecs = 10000;
        for (int i=0; i < 8; i++) {
            date.setTime(millisecs);
            System.out.println(date.toString());
            millisecs *= 10;
        }
    }
}