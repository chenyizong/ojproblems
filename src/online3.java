import java.util.*;

public class online3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int cyc = 0; cyc < n; cyc++) {
            int k = scanner.nextInt();
            int size = scanner.nextInt();
            int[] boards = new int[size];
            for (int i = 0; i < size; i++) {
                boards[i] = scanner.nextInt();
            }
            System.out.println(getTime(boards, k));
        }
    }

    public static int getTime(int[] arr, int num) {
        if (arr == null || arr.length == 0 || num < 1) {
            throw new RuntimeException("err");
        }
        if (arr.length < num) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i != arr.length; i++) {
                max = Math.max(max, arr[i]);
            }
            return max;
        } else {
            int minSum = 0;
            int maxSum = 0;
            for (int i = 0; i < arr.length; i++) {
                maxSum += arr[i];
            }
            while (minSum != maxSum - 1) {
                int mid = (minSum + maxSum) / 2;
                if (getNeedNum(arr, mid) > num) {
                    minSum = mid;
                } else {
                    maxSum = mid;
                }
            }
            return maxSum;
        }
    }

    public static int getNeedNum(int[] arr, int lim) {
        int res = 1;
        int stepSum = 0;
        for (int i = 0; i != arr.length; i++) {
            if (arr[i] > lim) {
                return Integer.MAX_VALUE;
            }
            stepSum += arr[i];
            if (stepSum > lim) {
                res++;
                stepSum = arr[i];
            }
        }
        return res;
    }
}