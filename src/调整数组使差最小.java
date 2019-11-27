/**
 * 调整数组使差最小
 * Description
 *
 * 有两个序列 a,b，大小都为 n,序列元素的值任意整数，无序； 要求：通过交换 a,b 中的元素，使[序列 a 元素的和]与[序列 b 元素的和]之间的差最小。
 *
 *
 * Input
 *
 * 输入第一行为用例个数， 每个测试用例输入为两行，分别为两个数组，每个值用空格隔开。
 *
 *
 * Output
 *
 * 输出变化之后的两个数组内元素和的差绝对值。
 *
 *
 * Sample Input 1
 *
 * 1
 * 100 99 98 1 2 3
 * 1 2 3 4 5 40
 * Sample Output 1
 *
 * 48
 */

import java.util.Scanner;

public class 调整数组使差最小 {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int Num = Integer.parseInt(sc.nextLine());
        while (Num > 0) {
            String astr = sc.nextLine();
            String[] arr = astr.split(" ");
            int n = arr.length;
            int[] a = new int[2*n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(arr[i]);
            }
            String bstr = sc.nextLine();
            String[] barr = bstr.split(" ");
            int j=0;
            for (int i = n; i < (2 * n); i++) {
                a[i] = Integer.parseInt(barr[j]);
                j++;
            }
            int sum = 0;
            for (int i = 0; i < 2 * n; i++) {
                sum = sum + a[i];
            }
            Double mid = sum/2.0;



            System.out.println(new Double(f(mid,a,0,n)*2).intValue());
            Num--;
        }
    }
    public static Double f(Double mid,int[] a,int index,int count){
        if(count==0){
            return mid;
        }
        if(index==a.length){
            return Double.MAX_VALUE;
        }
        if(a[index]>mid){
            return f(mid,a,index+1,count);
        }else {
            return Math.min(f(mid-a[index],a,index+1,count-1),f(mid,a,index+1,count));
        }

    }


}
