import java.util.Scanner;

public class fcfs {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter No Of Processes : ");
        int n = sc.nextInt();

        int process[] = new int[n];
        int arrival[] = new int[n];
        int burst[] = new int[n];
        int completion[] = new int[n];
        int TAT[] = new int[n];
        int WT[] = new int[n];

        float AVGTAT = 0, AVGWT = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter Process " + (i + 1) + " Arrival Time :");
            arrival[i] = sc.nextInt();

            System.out.print("Enter Process" + (i + 1) + " burst Time :");
            burst[i] = sc.nextInt();

            process[i] = i + 1;
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arrival[i] > arrival[j]) {
                    int temp = arrival[i];
                    arrival[i] = arrival[j];
                    arrival[j] = temp;

                    temp = burst[i];
                    burst[i] = burst[j];
                    burst[j] = temp;

                    temp = process[i];
                    process[i] = process[j];
                    process[j] = temp;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                completion[i] = arrival[i] + burst[i];
            } else {
                if (arrival[i] > completion[i - 1]) {
                    completion[i] = arrival[i] + burst[i];
                } else {
                    completion[i] = completion[i - 1] + burst[i];
                }
            }
        }
        System.out.print("\n\nProcess \tArrival \tburst \tCompletion \t\tWT \t\tTAT");
        for (int i = 0; i < n; i++) {
            TAT[i] = completion[i] - arrival[i];
            AVGTAT = AVGTAT + TAT[i];

            WT[i] = TAT[i] - burst[i];
            AVGWT = AVGWT + WT[i];

            System.out.print("\n" + process[i] + "\t\t" + arrival[i] + "\t\t" + burst[i] + "\t\t" + completion[i]
                    + "\t\t" + WT[i] + "\t\t" + TAT[i]);
        }

        System.out.print("\n\nAvergae Turn Around Time :" + (AVGTAT / n));
        System.out.print("\nAvergae Wait Time :" + (AVGWT / n));

        sc.close();
    }
}
