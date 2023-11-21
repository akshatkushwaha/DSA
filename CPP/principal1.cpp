#include <algorithm>
#include <iostream>
#include <map>
#include <vector>

using namespace std;

/*
    Problem Statement:
    You are given a array of integers. Sort the array in ascending order,
    then find the sum of product of element and the number of position it has moved from its original position.
*/

int printResult(vector<int> nums) {
    map<int, int> m;
    int sum = 0;

    for (int i = 0; i < nums.size(); ++i) {
        m.insert(make_pair(nums[i], i));
    }

    sort(nums.begin(), nums.end());

    for (int i = 0; i < nums.size(); ++i) {
        sum += nums[i] * abs(m[nums[i]] - i);
    }

    return sum;
}

int solve(vector<int> nums) {
    vector<int> original = nums;
    int size = nums.size();
    int sum = 0;

    sort(nums.begin(), nums.end());

    for (int i = 0; i < size; i++) {
        int index = find(original.begin(), original.end(), nums[i]) - original.begin();
        sum += nums[i] * abs(index - i);
    }

    return sum;
}

int main() {
    vector<int> nums = {4, 7, 2, 1, 9, 3};
    cout << solve(nums) << endl;
    cout << printResult(nums) << endl;
    return 0;
}