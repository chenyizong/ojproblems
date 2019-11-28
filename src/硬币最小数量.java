/**
 * 硬币最小数量
 * Description
 *
 * Given the list of coins of distinct denominations and total amount of money. Output the minimum number of coins required to make up that amount. Output -1 if that money cannot be made up using given coins. You may assume that there are infinite numbers of coins of each type.
 *
 *
 * Input
 *
 * The first line contains 'T' denoting the number of test cases. Then follows description of test cases. Each cases begins with the two space separated integers 'n' and 'amount' denoting the total number of distinct coins and total amount of money respectively. The second line contains N space-separated integers A1, A2, ..., AN denoting the values of coins.
 *
 * Constraints:1<=T<=30，1<=n<=100，1<=Ai<=1000，1<=amount<=100000
 *
 *
 * Output
 *
 * Print the minimum number of coins required to make up that amount or return -1 if it is impossible to make that amount using given coins.
 *
 *
 * Sample Input 1
 *
 * 2
 * 3 11
 * 1 2 5
 * 2 7
 * 2 6
 * Sample Output 1
 *
 * 3
 * -1
 */

import java.util.Arrays;
import java.util.Scanner;

class 硬币最小数量 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = Integer.parseInt(s.nextLine());
        while (t-- > 0) {
            int m = s.nextInt();
            int v = s.nextInt();
            int[] coins = new int[m];

            for (int i = 0; i < m; i++) {
                coins[i] = s.nextInt();
            }
            int[] dp = new int[v + 1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            for (int i = 0; i <= v; i++) {
                for (int j = 0; j < m; j++) {
                    if (i >= coins[j]) {
                        if (dp[i - coins[j]] != Integer.MAX_VALUE && dp[i - coins[j]] + 1 < dp[i]) {
                            dp[i] = dp[i - coins[j]] + 1;
                        }
                    }
                }
            }
            if (dp[v] != Integer.MAX_VALUE)
                System.out.println(dp[v]);
            else
                System.out.println(-1);
        }
    }
}