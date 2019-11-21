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
