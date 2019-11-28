/**
 * 时间与收益
 * Description
 *
 * Given a set of n jobs where each job i has a deadline and profit associated to it. Each job takes 1 unit of time to complete and only one job can be scheduled at a time. We earn the profit if and only if the job is completed by its deadline. The task is to find the maximum profit and the number of jobs done.
 *
 *
 * Input
 *
 * The first line of input contains an integer T denoting the number of test cases.Each test case consist of an integer N denoting the number of jobs and the next line consist of Job id, Deadline and the Profit associated to that Job.
 *
 * Constraints:1<=T<=100，1<=N<=100，1<=Deadline<=100，1<=Profit<=500
 *
 *
 * Output
 *
 * Output the number of jobs done and the maximum profit.
 *
 *
 * Sample Input 1
 *
 * 2
 * 4
 * 1 4 20 2 1 10 3 1 40 4 1 30
 * 5
 * 1 2 100 2 1 19 3 2 27 4 1 25 5 1 15
 * Sample Output 1
 *
 * 2 60
 * 2 127
 */

import java.lang.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Job {

    int id, dead, pro;

    Job(int id, int dead, int pro) {

        this.id=id;
        this.dead=dead;
        this.pro=pro;
    }
}

class 时间与收益 {

    public static void main (String[] args) {

        Scanner sc=new Scanner(System.in);

        int t=sc.nextInt();
        while(t-->0) {

            int n=sc.nextInt();

            Job[] job=new Job[n];

            for(int i=0; i<n; i++) {

                int x=sc.nextInt();
                int y=sc.nextInt();
                int z=sc.nextInt();

                job[i]=new Job(x, y, z);
            }

            Arrays.sort(job, new Comparator<Job>(){

                @Override
                public int compare(Job j1, Job j2) {

                    return (j2.pro-j1.pro);
                }
            });

            boolean[] slot=new boolean[n];
            int[] res=new int[n];
            Arrays.fill(slot, false);

            int ct=0, prof=0;
            for(int i=0; i<n; i++) {

                for(int j=Math.min(job[i].dead, n)-1; j>=0; j--) {

                    if(!slot[j]) {

                        slot[j]=true;
                        res[j]=i;
                        break;
                    }
                }
            }

            for(int i=0; i<n; i++) {

                if(slot[i]) {

                    ct++;
                    prof += job[res[i]].pro;
                }
            }

            System.out.println(ct +" "+ prof);
        }
    }
}