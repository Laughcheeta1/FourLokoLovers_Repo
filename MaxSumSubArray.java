import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This is a classic simple programming task, given an array of integers, find the maximum sum made by sub arrays
 * Example:
 *  The array [-1, 2, 4, -3, 10, -2] has the sub-array [2, 4, -3, 10] that is the biggest sum sub array with a sum of 13
 */
public class MaxSumSubArray {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");

        int[] result = new int[input.length];

        for (int i = 0; i < input.length; i++)
        {  // I would use streams, but the overhead of setting one up is not worth
            result[i] = Integer.parseInt(input[i]);
        }

        System.out.println(doTheWork(result));
    }

    /**
     * The idea here is the following:
     *  There is no need to create all the existing sub-arrays and sum them, we can make one pass and simulate exploring
     *  those sub arrays.
     *  I'll explain it in text, and then I'll show an example.
     *      When we are calculating this sub-arrays we are concerned only with the sum of them, therefore our way of
     *      exploring them will be via sums. We are going to have a variable that has out best sub-array (max) and a
     *      variable with the current sub array we are exploring (current), while we make the sums we are going to say
     *      that we finished exploring a subarray when the sum of it becomes negative, this because no matter if the
     *      following number is positive or whatever, it will make no sense to have that new number summed to a previous
     *      sub-array that sums-up to a negative number, therefore we are going to "explore" a new sub-array via setting
     *      our current variable to 0, we continue to do that and interchanging the max with the current when it's due,
     *      and we will have our answer.
     *
     *  An example will explain it better:
     *      Lets say we have: [-2, 4, 6, -11, 5, 9, -3, 4]
     *      and: current = 0, max = 0
     *
     *      When we go to the first value, and add it to current, but since it will make current negative, we can ignore
     *      that sub-array (composed of only [-2]), and move to the next sub-array.
     *      - Then we go to 4 and add it to the current (we will add the current index always) and update the max
     *      - We go to 6 and do the same
     *          At this point we can say we have explored the sub-array [4, 6], but you can clearly notice that the
     *          following number will make it so that sub-array is not more expandable, since this current sub-array sum
     *          (4 + 6 = 10) is eclipsed by the -11, therefore all sub-arrays that contain the [4, 6, -11] will be a
     *          detriment, so we can forget (not from the max, since we do not know if [4, 6] is the max subarray) it.
     *      - We go to the -11 and add it to the current, and since the sum becomes negative (4 + 6 - 11 = -1), we will
     *        "search" another sub-array by setting the current to 0, we remain with the max = 10 (due to the sub-array
     *        [4, 6])
     *      - We go to the 5 and add it to the current, but since current (= 5) is not better than max (= 10), we leave
     *        max untouched.
     *      - We go to the 9, add it to current, and update the max, max will now be = 14, so we can see how we changed
     *        from the max sub-array being [4, 6] to being [5, 9] without actually having to create them.
     *      - We got to the -3 and add it to current, but since current will NOT be negative, we will leave it as is,
     *        since any numbers that come after, will still have a net gain of (5 + 9 - 3 =) 11, that is why we do not
     *        reset current. So the variable current has right now the sub-array [5, 9, -3] "encoded" within it.
     *      - We finally get to the final 4, add it to current, and we get a sum of (5 + 9 -3 + 4 =) 15, that is our max.
     *
     *      When we return this max we will, in a kind of way, be returning the sub-array [5, 9, -3, 4]
     *
     *      NOTE: see that if the final number was a number equal or less than 3, the max sub-array would still be [5, 9]
     *          and that is in a kind of way, already encoded by the code, since the max would not be updated.
     *      NOTE 2: note that I said if the last number was less EQUAL to 3; but actually, if it was equal to 3, both
     *          [5, 9] and [5, 9, -3, 3] would yield the best sum, but the way I coded it, it will remain with the first
     *          combination it encounters, not the one with fewer numbers or with most numbers, although this can easily
     *          be changed to however you want via adding a new variable that keeps track of this length of the sub-array.
     */
    private static int doTheWork(int[] input)
    {
        int max = 0;
        int current = 0;

        for (int i : input)
        {
            current += i;
            if (current < 0)
                current = 0;

            if (current > max)
                max = current;
        }

        return max;
    }
}
