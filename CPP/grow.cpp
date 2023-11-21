#include <iostream>
#include <unordered_map>

using namespace std;

/*
you ar given a non-decreasing array A of size N.
You must answer Q quaries for the array.
You are given two indices for each query, L and R (where L <= R).
You must create a subarray from index L to index R.

Print the number of elements in subarray A[L....R] equal to the average of subarray A[L....R] for each query.
*/

int avgSubarray(int N, int Q, int A[], int L[], int R[]) {
    for (int i = 0; i < Q; i++) {
        int sum = 0;
        int count = 0;
        unordered_map<int, int> freq;

        for (int j = L[i] - 1; j <= R[i] - 1; ++j) {
            sum += A[j];
            freq[A[j]]++;
        }

        double avg = (double)sum / (R[i] - L[i] + 1);

        if (sum % (R[i] - L[i] + 1) == 0 && freq.find(avg) != freq.end()) {
            count = freq[avg];
        }

        cout << count << endl;
    }

    return 0;
}

int main() {
    int N = 6, Q = 3;
    int A[] = {1, 3, 3, 5, 5, 6};

    int L[] = {1, 5, 1};
    int R[] = {4, 5, 6};

    avgSubarray(N, Q, A, L, R);

    return 0;
}