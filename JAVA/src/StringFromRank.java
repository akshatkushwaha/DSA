
/*
Finding the rank of a string is the basic concept one needs to learn to understand Permutations. To understand it deeply why don't we reverse engineer it?
Rank is nothing but the position of string among all the possible permutations without repetition of alphabets of length N in lexicographical order.
The possible permutations without repetition of

length 1 is a, b, c .. z,
length 2 is ab, ac, ad .. zy,
length 3 is abc, abd, abe, ... bac, bad, bae ... zyx,
and so on.

Now, given rank of a string and its length, compute the string that can be formed with all the alphabets. Check example section for more understanding
 */

import java.util.Scanner;

public class StringFromRank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rank = scanner.nextInt();
        int length = scanner.nextInt();

        System.out.println(getStringFromRank(rank, length));

        scanner.close();
    }

    private static String getStringFromRank(int rank, int length) {
        StringBuilder result = new StringBuilder();

        // Create a boolean array to keep track of alphabets that are used
        boolean[] used = new boolean[26];

        // Iterate through all the positions in the string
        for (int position = 0; position < length; position++) {
            // Iterate through all the alphabets
            for (int alphabet = 0; alphabet < 26; alphabet++) {
                // Check if the alphabet is used
                if (!used[alphabet]) {
                    // If the alphabet is not used, then check if the rank is less than the
                    // factorial of the length of the string minus the position minus 1
                    if (rank < factorial(length - position - 1)) {
                        // If the rank is less than the factorial of the length of the string minus
                        // the position minus 1, then add the alphabet to the result and mark it as
                        // used
                        result.append((char) (alphabet + 'a'));
                        used[alphabet] = true;

                        // Break out of the loop
                        break;
                    } else {
                        // If the rank is greater than or equal to the factorial of the length of the
                        // string minus the position minus 1, then subtract the factorial from the
                        // rank
                        rank -= factorial(length - position - 1);
                    }
                }
            }
        }

        return result.toString();
    }

    private static int factorial(int i) {
        // If i is 0, then return 1
        if (i == 0) {
            return 1;
        }

        // Otherwise, return i * factorial(i - 1)
        return i * factorial(i - 1);
    }
}
