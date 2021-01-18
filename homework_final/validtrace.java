import java.util.Scanner;

public class validtrace {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        int n = input.nextInt();
        char[][] board = new char[m][n];
        String str = input.next();
        String target = input.next();
        input.close();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = str.charAt(i * n + j);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, m, n, target, 0, 0, 0)) {
                    System.out.print("true");
                    return;
                }
            }
        }
        System.out.print("false");
    }

    public static boolean dfs(char[][] board, int m, int n, String target, int i, int j, int k) {
        if (i < 0 || i >= m || j >= n || j < 0 || board[i][j] != target.charAt(k))
            return false;
        if (k == target.length() - 1)
            return true;
        char temp = board[i][j];
        board[i][j] = '/';
        boolean res = dfs(board, m, n, target, i - 1, j, k + 1) || dfs(board, m, n, target, i + 1, j, k + 1)
                || dfs(board, m, n, target, i, j - 1, k + 1) || dfs(board, m, n, target, i, j + 1, k + 1);
        board[i][j] = temp;
        return res;
    }

    public static void printBoard(char[][] board) {
        for (char[] line : board) {
            for (char item : line) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }
}
