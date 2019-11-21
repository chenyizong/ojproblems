import java.util.Scanner;

/**
 * Description
 * Cows in the FooLand city are interesting animals.
 * One of their specialties is related to producing offsprings.
 * A cow in FooLand produces its first calve (female calf) at the age of two years and proceeds to produce other calves
 * (one female calf a year).
 * Now the farmer Harold wants to know how many animals would he have at the end of N years,
 * if we assume that none of the calves die, given that initially, he has only one female calf?
 *
 *  explanation:
 * At the end of 1 year, he will have only 1 cow,
 * at the end of 2 years he will have 2 animals (one parent cow C1 and other baby calf B1 which is the offspring of cow C1).
 * At the end of 3 years, he will have 3 animals (one parent cow C1 and 2 female calves B1 and B2, C1 is the parent of B1 and B2).
 * At the end of 4 years, he will have 5 animals (one parent cow C1, 3 offsprings of C1 i.e. B1, B2, B3 and one offspring of B1).
 *
 * Input
 * The first line contains a single integer T denoting the number of test cases. Each line of the test case contains a single integer N as described in the problem.
 *
 * Output
 * For each test case print in new line the number of animals expected at the end of N years modulo 10^9 + 7.
 */
public class online2_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Num = Integer.parseInt(sc.nextLine());
        while (Num > 0) {
            int year = Integer.parseInt(sc.nextLine());
            long sum = 0;
            long[] newborn = new long[year];
            for (int i = 0; i < year; i++) {
                if (i < 3) {
                    newborn[i] = 1;
                } else {
                    newborn[i] = newborn[i - 1] + newborn[i - 3];
                }
                sum += newborn[i];
            }
            System.out.println(sum%1000000007);
            Num--;
        }
    }


}
