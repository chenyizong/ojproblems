import java.util.Scanner;

public class ShellSorted {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Num = Integer.parseInt(sc.nextLine());
        while (Num > 0) {
            String[] strs = sc.nextLine().split(" ");
            int[] nums = new int[strs.length];
            for (int i = 0; i < strs.length; i++) {
                nums[i] = Integer.parseInt(strs[i]);
            }
            String[] str2 = sc.nextLine().split(" ");
            int[] indexs = new int[str2.length];
            for (int j = 0; j < str2.length; j++) {
                indexs[j] = Integer.parseInt(str2[j]);
            }

            for (int k = 0; k < indexs.length; k++) {
                shellSort(nums, indexs[k]);
            }
            String res = "";
            for (int q = 0; q < nums.length - 1; q++) {
                res = res + nums[q] + " ";
            }
            res = res + nums[nums.length - 1];
            System.out.println(res);

            Num--;
        }
    }

    static void shellSort(int[] data, int step) {
        int j = 0;
        int min = 0;
        for (int i = step; i < data.length; i++) {
            min = data[i];
            for (j = i; j >= step; j -= step) {
                if (min < data[j - step]) {
                    data[j] = data[j - step];
                } else {
                    break;
                }
            }
            data[j] = min;
        }
    }
}
