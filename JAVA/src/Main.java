import java.util.*;

/*
 * Given are an integer array A[i] of size N and a single integer, K. The goodness of an array is the sum of all the numbers in that array.
 * You must perform the following operation exactly K times:
 * * Remove the maximum number from the array such that the sum of these K numbers should be less or ewual to the removed elements.
 * 
 * Find the decrease in the godness level of the array, which is obtained by the diffrence between the goodness of the intial array and the goodness of the final array ( after K operations).
 */

class Main {
    int goodnessOfArray(int[] A, int K, int N) {
        int sum = 0;
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < K; i++) {
            max = 0;
            for (int j = 0; j < N; j++) {
                if (A[j] > max) {
                    max = A[j];
                    maxIndex = j;
                }
            }
            sum += max;
            A[maxIndex] = 0;
        }
        return sum;
    }

    public static void main(String args[]) {
    }
}