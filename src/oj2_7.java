import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class oj2_7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            String[] s2 = s.split(" ");
            int n = Integer.parseInt(s2[0]);
            String[] s3 = Arrays.copyOfRange(s2, 1, s2.length);
            int[] ints = new int[n];
            for (int i = 0; i < n; i++) {
                ints[i] = Integer.parseInt(s3[i]);
            }

            nonRecrutSort(ints);
            String res = "";
            for (int p = 0; p < n - 1; p++) {
                res = res + ints[p] + " ";
            }
            res = res + ints[n - 1];
            System.out.println(res);

        }
    }

    public static void nonRecrutSort(int[] a) {
        //非递归快排，两个栈
        //设置两个栈，一个用于保存
        /**
         * 保存当前划分的最高位
         */
        Stack<Integer> startStack = new Stack<>();
        /**
         * 保存当前划分的最低位
         */
        Stack<Integer> endStack = new Stack<>();
        int start = 0;
        int end = a.length - 1;

        int pivotPos;

        startStack.push(start);
        endStack.push(end);

        while (!startStack.isEmpty()) {
            start = startStack.pop();
            end = endStack.pop();
            pivotPos = partition(a, start, end);
            if (start < pivotPos - 1) {
                startStack.push(start);
                endStack.push(pivotPos - 1);
            }
            if (end > pivotPos + 1) {
                startStack.push(pivotPos + 1);
                endStack.push(end);
            }
        }
    }

    public static int partition(int[] a, int start, int end) {
        //分块方法，在数组a中，对下标从start到end的数列进行划分
        int pivot = a[start];                     //把比pivot(初始的pivot=a[start]小的数移动到pivot的左边
        while (start < end) {                       //把比pivot大的数移动到pivot的右边
            while (start < end && a[end] >= pivot) {
                end--;
            }
            a[start] = a[end];
            while (start < end && a[start] <= pivot) {
                start++;
            }
            a[end] = a[start];
        }
        a[start] = pivot;
        return start;//返回划分后的pivot的位置
    }

}
