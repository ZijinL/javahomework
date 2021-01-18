import java.lang.Math;

class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j < n + 1; j++) {
            dp[0][j] = j;
        }
        printboard(dp);

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                int up_value = dp[i - 1][j] + 1;
                int left_value = dp[i][j - 1] + 1;
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    left_value = Math.min(left_value, dp[i - 1][j - 1]);
                else
                    left_value = Math.min(left_value, dp[i - 1][j - 1] + 1);
                dp[i][j] = Math.min(up_value, left_value);
            }
        }
        printboard(dp);
        return dp[m][n];
    }

    public int[][] genboard(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] board = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    board[i][j] = 0;
                } else {
                    board[i][j] = 1;
                }
            }
        }
        return board;
    }

    public void printboard(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}

public class editDistance {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.minDistance("a", "ab");

    }
}