import java.util.Scanner;

class 如何花最少的钱购买蔬菜 {
    //look for minimum value withing range
    public static int getMin(int arr[], int l, int h) {
        int res = Integer.MAX_VALUE;
        for (int i = l; i <= h; ++i) {
            if (arr[i] < res) {
                res = arr[i];
            }
        }
        return res;
    }

    public static int minCost(int arr[][], int n) {
        int dp[][] = new int[n][3];
        for (int i = 0; i < 3; ++i)
            dp[0][i] = arr[0][i];
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < 3; ++j) {
                dp[i][j] = Math.min(getMin(dp[i - 1], 0, j - 1), getMin(dp[i - 1], j + 1, 2)) + arr[i][j];

            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < 3; ++i)
            if (dp[n - 1][i] < res)
                res = dp[n - 1][i];
        return res;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            int n = Integer.parseInt(sc.nextLine());
            int arr[][] = new int[n][3];
            for (int i = 0; i < n; ++i) {
                String[] temp = sc.nextLine().split(" ");
                for (int j = 0; j < 3; j++) {
                    arr[i][j] = Integer.parseInt(temp[j]);
                }
            }
            System.out.println(minCost(arr, n));
        }
    }
}