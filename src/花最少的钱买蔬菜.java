import java.lang.*;
import java.io.*;
import java.util.Scanner;

class Sample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        for (int index = 0;index < tests;index++) {
            int n = sc.nextInt();
            int arr[][] = new int[3][n];
            int arrLog[][] = new int[3][n];
            for (int indexi = 0;indexi < n;indexi++) {
                for (int indexj = 0;indexj < 3;indexj++) {
                    arr[indexj][indexi] = sc.nextInt();
                    arrLog[indexj][indexi] = 0;
                }
            }

            arrLog[0][n - 1] = arr[0][n - 1];
            arrLog[1][n - 1] = arr[1][n - 1];
            arrLog[2][n - 1] = arr[2][n - 1];
            for (int indexj = n - 2;indexj >= 0;indexj--) {
                arrLog[0][indexj] = Math.min(arrLog[1][indexj + 1], arrLog[2][indexj + 1]) + arr[0][indexj];
                arrLog[1][indexj] = Math.min(arrLog[2][indexj + 1], arrLog[0][indexj + 1]) + arr[1][indexj];
                arrLog[2][indexj] = Math.min(arrLog[0][indexj + 1], arrLog[1][indexj + 1]) + arr[2][indexj];
            }

            System.out.println(Math.min(arrLog[0][0], Math.min(arrLog[1][0], arrLog[2][0])));
        }
    }
}
