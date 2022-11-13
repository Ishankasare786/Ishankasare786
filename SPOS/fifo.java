import java.util.Scanner;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class fifo {
    public static void main(String[] args) {

        // take inputs
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the frame size : ");

        int fr = sc.nextInt();

        System.out.println("Enter the number of pages");

        int pg = sc.nextInt();

        System.out.println("Enter the pages : ");
        int[] pages = new int[pg];

        for (int i = 0; i < pg; i++) {

            pages[i] = sc.nextInt();
        }
        
        int page_faults = 0;
        int hits = 0;

        HashSet<Integer> hash = new HashSet<>(fr);
        Queue<Integer> indexes = new LinkedList<>();

        for (int i = 0; i < pg; i++) 
        {
            if (hash.size() < fr) 
            {
                if (!hash.contains(pages[i])) 
                {
                    hash.add(pages[i]); 

                    page_faults++; 

                    indexes.add(pages[i]); 
                }
            } else 
            {
                if (!hash.contains(pages[i])) {
                    int val = indexes.peek(); 

                    indexes.poll(); 

                    hash.remove(val); 

                    hash.add(pages[i]); 

                    indexes.add(pages[i]); 

                    page_faults++; 
                }
            }
            System.out.println(" " + hash);

        }

        System.out.println("Page Faults : " + page_faults);

        hits = pg - page_faults;

        System.out.println("Hits : " + hits);
    }
}
