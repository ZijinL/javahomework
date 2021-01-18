import java.util.ArrayList;
import java.util.Random;
public class homework_3_3 {
    public static void main (String [] args) {
        ArrayList<Number> list = new ArrayList<Number>();
        Random r = new Random();
        System.out.print("\n未排序: ");
        for (int i=0; i < 10; i++) {
            int temp = r.nextInt(100);
            System.out.print(temp + " | ");
            list.add(temp);
        }
        System.out.print("\n排序后: ");
        sort(list);
        for (int i=0; i < list.size(); i++) {
            System.out.print(list.get(i) + " <= ");
        }
    }
    // bublle sort 
    public static void sort(ArrayList<Number> list) {
        for (int i=0; i < list.size()-1; i++) {
            int flag = 0; // 如果某趟未排序则提前结束
            for (int j=0; j < list.size()-1-i; j++) {
                flag = 1;
                if (list.get(j).doubleValue() > list.get(j+1).doubleValue()) {
                    Number temp = list.get(j);
                    list.set(j, list.get(j+1));
                    list.set(j+1, temp);
                }
            }
            if (flag == 0) break;
        }
    }
}
