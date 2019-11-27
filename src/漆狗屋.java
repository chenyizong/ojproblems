/**
 * 漆狗屋
 * Description
 *
 * Dilpreet wants to paint his dog- Buzo's home that has n boards with different lengths[A1, A2,..., An]. He hired k painters for this work and each painter takes 1 unit time to paint 1 unit of the board.The problem is to find the minimum time to get this job done under the constraints that any painter will only paint continuous sections of boards, say board {2, 3, 4} or only board {1} or nothing but not board {2, 4, 5}.
 *
 * Constraints:1<=T<=100,1<=k<=30,1<=n<=50,1<=A[i]<=500
 *
 *
 * Input
 *
 * The first line consists of a single integer T, the number of test cases. For each test case, the first line contains an integer k denoting the number of painters and integer n denoting the number of boards. Next line contains n- space separated integers denoting the size of boards.
 *
 *
 * Output
 *
 * For each test case, the output is an integer displaying the minimum time for painting that house.
 *
 *
 * Sample Input 1
 *
 * 2
 * 2 4
 * 10 10 10 10
 * 2 4
 * 10 20 30 40
 * Sample Output 1
 *
 * 20
 * 60
 */

import java.util.Scanner;

public class 漆狗屋 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Num = Integer.parseInt(sc.nextLine());
        while (Num > 0) {
            String str1 = sc.nextLine();
            String[] s = str1.split(" ");
            int painter = Integer.parseInt(s[0]);
            int n = Integer.parseInt(s[1]);
            String[] str2 = sc.nextLine().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(str2[i]);
            }
            System.out.println(partition(arr, n, painter));
            Num--;
        }
    }

    static int partition(int[] arr, int n, int k) {
        int lo = getMax(arr, n);
        int hi = getSum(arr, n);
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int requiredPainters = numberOfPainters(arr, n, mid);

            // find better optimum in lower half
            // here mid is included because we
            // may not get anything better
            if (requiredPainters <= k) {
                hi = mid;
            }

            // find better optimum in upper half
            // here mid is excluded because it gives
            // required Painters > k, which is invalid
            else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    // find minimum required painters for given maxlen
    // which is the maximum length a painter can paint
    static int numberOfPainters(int arr[], int n, int maxLen) {
        int total = 0, numPainters = 1;

        for (int i = 0; i < n; i++) {
            total += arr[i];

            if (total > maxLen) {

                // for next count
                total = arr[i];
                numPainters++;
            }
        }

        return numPainters;
    }

    static int getMax(int[] arr, int n) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    static int getSum(int arr[], int n) {
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += arr[i];
        }
        return total;
    }


}
