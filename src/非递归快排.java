/**
 * 非递归快排
 * Description
 *
 * 快速排序的核心思想是使用元素的值对数组进行划分。实现其非递归方案。
 *
 *
 * Input
 *
 * 输入的每一行表示一个元素为正整数的数组，所有值用空格隔开，第一个值为数值长度，其余为数组元素值。
 *
 *
 * Output
 *
 * 输出的每一行为排序结果，用空格隔开，末尾不要空格。
 *
 *
 * Sample Input 1
 *
 * 13 24 3 56 34 3 78 12 29 49 84 51 9 100
 * Sample Output 1
 *
 * 3 3 9 12 24 29 34 49 51 56 78 84 100
 */

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class 非递归快排 {
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
