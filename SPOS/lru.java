import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class lru {
    public static void main(String[] args) {
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

        int hits = 0;
        

        HashSet<Integer> hash = new HashSet<>(fr);

        

        HashMap<Integer, Integer> indexes = new HashMap<>();

        
        int page_faults = 0;

        for (int i = 0; i < pg; i++) {
            
            if (hash.size() < fr) {

                
                if (!hash.contains(pages[i])) {
                    
                    hash.add(pages[i]);

                    
                    page_faults++;
                } else {
                    hits++;
                }

                
                indexes.put(pages[i], i);
            }
            
            else {
                
                int lru = Integer.MAX_VALUE, value = Integer.MIN_VALUE;

                Iterator<Integer> itr = hash.iterator();

                while (itr.hasNext()) {
                    int temp = itr.next();
                    if (indexes.get(temp) < lru) {
                        lru = indexes.get(temp);
                        value = temp;
                    }
                }

                if (!hash.contains(pages[i])) {
                    hash.add(pages[i]);

                    
                    page_faults++;
                } else {
                    hits++;
                }

               
                hash.remove(value);
                
                hash.add(pages[i]);

                
                indexes.put(pages[i], i);

            }

            // System.out.println(" " + hash);
        }

        System.out.println("pages : " + pg);

        System.out.println("page frames : " + fr);

        System.out.println("page faults : " + page_faults);

        System.out.println("page hits : " + hits);

    }

}