/**
 * 固定和的元素对
 * Description
 *
 * 输入一个数组和一个数字，在数组中查找两个数，使得它们的和正好是输入的那个数字，统计这样两个数的对数。
 *
 *
 * Input
 *
 * 输入第一行为用例个数， 每个测试用例输入第一行是数组，每一个数用空格隔开；第二行是数字和。
 *
 *
 * Output
 *
 * 输出这样两个数有几对。
 *
 *
 * Sample Input 1
 *
 * 1
 * 1 2 4 7 11 0 9 15
 * 11
 * Sample Output 1
 *
 * 3
 */

import java.util.Arrays;
import java.util.Scanner;

public class 固定和的元素对 {

    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int Num = Integer.parseInt(sc.nextLine());
        while (Num > 0) {
            int res = 0;
            String s = sc.nextLine();
            String[] arr = s.split(" ");
            int[] ints = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                ints[i] = Integer.parseInt(arr[i]);
            }
            Arrays.sort(ints);
            int num = Integer.parseInt(sc.nextLine());
            int i=0;
            int j=arr.length-1;
            while(i<j){
                if(ints[i]+ints[j]>num){
                    j--;
                }else if(ints[i]+ints[j]<num){
                    i++;
                }else{
                    res++;
                    i++;
                    j--;
                }
            }
            Num--;
            System.out.println(res);
        }
    }
}
