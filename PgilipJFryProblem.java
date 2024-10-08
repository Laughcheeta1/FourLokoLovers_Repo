import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n;
        // Cada test case
        while ((n = scan.nextInt()) != 0) {
            if (n == 1)
            {
                int r = scan.nextInt();
                scan.nextLong();

                System.out.println(r);
                continue;
            }

            int[] tripTime = new int[n];  // Time taken by the ith trip
            int[] poop = new int[n];  // Poop quantity from the day i

            // Read all the inputs first to be able to determine the shortest time possible
            for (int i = 0; i < n; i++)
            {
                tripTime[i] = scan.nextInt();  // Save the time taken by the ith trip
                poop[i] = scan.nextInt();  // Save the poop quantity for the ith day
            }

            long timeCount = 0;  // Final time taken
            int poopCount;  // helper
            PriorityQueue<Integer> numbers = new PriorityQueue<>(Comparator.reverseOrder());

            for (int day = n - 2; day >= 0; day--)  // Go throught all the days in ascending order to use the poop available
            {
                numbers.add(tripTime[day + 1]);

                for (poopCount = poop[day]; poopCount > 0; poopCount --)  // Expend all the poop available in the day
                {
                    if (numbers.isEmpty())  // There is no more trips to shorten with the poop
                        break;
 
                    timeCount += numbers.poll() / 2;  // Get the longest remaining trip
                }
            }

            timeCount += tripTime[0];  // Add the time taken by the first trip

            while (!numbers.isEmpty())  // In case there are more trips than poop
                timeCount += numbers.poll();

            System.out.println(timeCount);
        }

        scan.close();
    }
}