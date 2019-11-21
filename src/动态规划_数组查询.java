import java.util.Scanner;

public class 动态规划_数组查询 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Num = Integer.parseInt(sc.nextLine());
        while (Num > 0) {
            int n = Integer.parseInt(sc.nextLine());
            String[] str = sc.nextLine().split(" ");
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(str[i]);
            }
            int tmp[] = new int[n];
            tmp[0] = nums[0];
            int max = Integer.MIN_VALUE;
            int neg = 0;
            int[] negs = new int[100];
            int index = 0;
            for (int p = 0; p < n; p++) {
                if (nums[p] < 0) {
                    neg++;
                    negs[index] = p;
                    index++;
                }
            }
            int a = 0;
            int res = Integer.MIN_VALUE;
            if (index == 0) {
                int sum = 0;
                for (int k = 0; k < n; k++) {
                    sum = sum + nums[k];
                }
                res = sum;
            } else if(index==n){
                int x = Integer.MIN_VALUE;
                for(int l=0;l<n;l++){
                    if(nums[l]>x){
                        x = nums[l];
                    }
                }
                res = x;
            } else {
                for (int q = 0; q < neg; q++) {
                    a = nums[negs[q]];
                    nums[negs[q]] = 0;
                    for (int j = 1; j < n; ++j) {
                        if (tmp[j - 1] > 0) {
                            tmp[j] = tmp[j - 1] + nums[j];
                        } else {
                            tmp[j] = nums[j];
                        }
                        if (tmp[j] > max) {
                            max = tmp[j];
                        }
                    }
                    if (max > res) {
                        res = max;
                    }
                    nums[negs[q]] = a;
                }
            }
            System.out.println(res);
            Num--;
        }
    }
}
