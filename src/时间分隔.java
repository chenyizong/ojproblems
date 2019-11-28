/**
 * 时间分隔
 * Description
 *
 * Given arrival and departure times of all trains that reach a railway station. Your task is to find the minimum number of platforms required for the railway station so that no train waits.
 *
 * Note: Consider that all the trains arrive on the same day and leave on the same day. Also, arrival and departure times must not be same for a train.
 *
 *
 * Input
 *
 * The first line of input contains T, the number of test cases. For each test case, first line will contain an integer N, the number of trains. Next two lines will consist of N space separated time intervals denoting arrival and departure times respectively.
 *
 * Note: Time intervals are in the 24-hourformat(hhmm), preceding zeros are insignificant. 200 means 2:00.
 * Consider the example for better understanding of input.
 *
 * Constraints:1 <= T <= 100，1 <= N <= 1000，1 <= A[i] < D[i] <= 2359
 *
 *
 * Output
 *
 * For each test case, print the minimum number of platforms required for the trains to arrive and depart safely.
 *
 *
 * Sample Input 1
 *
 * 1
 * 6
 * 900  940 950  1100 1500 1800
 * 910 1200 1120 1130 1900 2000
 * Sample Output 1
 *
 * 3
 */

import java.util.Arrays;
import java.util.Scanner;

class 时间分隔 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t > 0) {
            int n = s.nextInt();
            int[] arr = new int[n];
            int[] dept = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = s.nextInt();
            for (int i = 0; i < n; i++)
                dept[i] = s.nextInt();

            System.out.println(compute(arr, dept, n));
            t--;
        }
    }

    public static int compute(int[] arr, int[] dept, int n) {
        int max = 1, curr = 1;
        Arrays.sort(arr);
        Arrays.sort(dept);
        int i = 1, j = 0;
        while (i < n && j < n) {
            if (arr[i] < dept[j]) {
                curr++;
                if (curr > max)
                    max = curr;
                i++;
            } else {
                curr--;
                j++;
            }
        }
        return max;
    }
}