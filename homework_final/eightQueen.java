import java.util.Arrays;

public class eightQueen {
    static int res = 0;
    public static void main(String[] args) {
        int[] queen = new int[8];
        Arrays.fill(queen, -1);
        genqueen(queen, 0);
        System.out.println(res);
    }

    public static void genqueen(int[] queen, int row) {
        int length = queen.length;
        if (row == length) {
            System.out.println();
            printqueen(queen);
            res += 1;
        }
        for (int i = 0; i < length; i++) {
            if (checkpos(queen, row, i)) {
                queen[row] = i;
                genqueen(queen, row + 1);
            }
        }
    }

    public static boolean checkpos(int[] queen, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (queen[i] == col)
                return false;
            else if (queen[i] + i == col + row)
                return false;
            else if (queen[i] - i == col - row)
                return false;
        }
        return true;
    }

    public static void printqueen(int[] queen) {
        int length = queen.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (queen[i] == j)
                    System.out.print("Q ");
                else
                    System.out.print("x ");
            }
            System.out.println();
        }
    }
}
