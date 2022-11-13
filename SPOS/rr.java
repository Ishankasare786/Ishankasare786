import java.util.*;

public class rr {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter no of processes : ");
        int n = sc.nextInt();
        int pid[] = new int[n];
        int bt[] = new int[n];
        int tat[] = new int[n];
        int wt[] = new int[n];
        int rem_bt[] = new int[n];
        int time_qt;
        int total_t = 0;
        int avgtat = 0;
        int avgwt = 0;

        for (int i = 0; i < n; i++) {
            System.out.println("enter burst time for process : " + (i + 1));
            bt[i] = sc.nextInt();
            rem_bt[i] = bt[i];
            pid[i] = (i + 1);

        }

        System.out.println("Enter time quantum : ");
        time_qt = sc.nextInt();

        while (true) {
            boolean done = true;
            for (int i = 0; i < n; i++) {
                if (rem_bt[i] > 0) {
                    done = false;
                    if (rem_bt[i] > time_qt) {
                        total_t += time_qt;
                        rem_bt[i] -= time_qt;
                    } else {
                        total_t += rem_bt[i];
                        wt[i] = total_t - bt[i];
                        rem_bt[i] = 0;
                    }
                }

            }
            if (done == true) {
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            tat[i] = wt[i] + bt[i];
            avgtat += tat[i];
            avgwt += wt[i];
        }

        System.out.println("pid     bt      tat       wt");

        for (int i = 0; i < n; i++) {
            System.out.println(pid[i] + "\t" + bt[i] + "\t" + tat[i] + "\t" + wt[i]);
        }
        System.out.println("average tat : " + (avgtat / n));
        System.out.println("average wt : " + (avgwt / n));
    }
}
