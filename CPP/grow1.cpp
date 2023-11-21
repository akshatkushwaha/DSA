/*
 * Given are an integer array A[i] of size N and a single integer, K. The goodness of an array is the sum of all the
 * numbers in that array. You must perform the following operation exactly K times:
 * -> Remove the maximum number from the array and push any non-negative value exactly K time into the array such that
 * the sum of these K number should be less than or equal to the removed element.
 *
 * Find the decrease in the godness level of the array, which is obtained by the diffrence between the goodness of the
 * intial array and the goodness of the final array ( after K operations).
 *
 * Find mimum possible decrease in the goodness level of the array.
 */
#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int goodnessOfArray(int N, int K, int A[]) {
    int sum = 0;
    int max = 0;
    int maxIndex = 0;
    int count = 0;
    vector<int> v;

    for (int i = 0; i < N; i++) {
        sum += A[i];
        if (A[i] > max) {
            max = A[i];
            maxIndex = i;
        }
    }

    if (sum % K == 0) {
        count = sum / K;
    } else {
        count = sum / K + 1;
    }

    for (int i = 0; i < K; i++) {
        v.push_back(count);
    }

    int diff = max - count * K;

    for (int i = 0; i < diff; i++) {
        v[i]++;
    }

    int goodness = 0;

    for (int i = 0; i < N; i++) {
        if (i != maxIndex) {
            goodness += A[i];
        }
    }

    for (int i = 0; i < K; i++) {
        goodness -= v[i];
    }

    return goodness;
}

int main() {
    int N = 4;
    int K = 5;
    int A[] = {5, 4, 10, 6};

    int decreaseInGoodness = goodnessOfArray(N, K, A);
    std::cout << "Minimum possible decrease in goodness level: " << decreaseInGoodness << std::endl;

    return 0;
}
