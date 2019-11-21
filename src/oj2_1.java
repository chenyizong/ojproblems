import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import java.util.*;

public class oj2_1 {
    static Set<String> set1 = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Num = Integer.parseInt(sc.nextLine());
        while (Num > 0) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            int[][] dp = LCS(s1, s2);
            int x = s1.length();
            int y = s2.length();
            String res = "";
            prin(dp, s1, s2, x, y, res);
            List<String> list = new ArrayList<>(set1);
            Collections.sort(list);
            for (String e : list) {
                System.out.println(e);
            }
            Num--;
            set1.clear();
        }
    }

    public static int[][] LCS(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        int[][] dp = new int[l1 + 1][l2 + 1];
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        for (int row = 0; row <= l1; row++) {
            dp[row][0] = 0;
        }
        for (int column = 0; column <= l2; column++) {
            dp[0][column] = 0;
        }
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (str1[i - 1] == str2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else if (dp[i][j - 1] > dp[i - 1][j]) {
                    dp[i][j] = dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp;
    }


    public static void prin(int[][] dp, String s1, String s2, int x, int y, String res) {
        while (x >= 0 && y >= 0) {
            if (x == 0 || y == 0) {
                set1.add(new StringBuilder(res).reverse().toString());
                break;
            }
            if (x > 0 && y > 0 && s1.charAt(x-1) == s2.charAt(y-1)) {
                res = res + s1.charAt(x-1);
                prin(dp, s1, s2, x - 1, y - 1, res);
                return;
            } else {
                if (x > 0 && y > 0 && dp[x - 1][y] == dp[x][y - 1]) {
                    prin(dp, s1, s2, x - 1, y, res);
                    prin(dp, s1, s2, x, y - 1, res);
                    return;
                } else if (x > 0 && y > 0 && dp[x - 1][y] > dp[x][y - 1]) {
                    x--;
                } else {
                    y--;
                }
            }
        }
    }


}
