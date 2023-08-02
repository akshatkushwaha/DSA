#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
// Leetcode 31. Next Permutation
class Solution
{
public:
    void nextPermutation(vector<int> &nums)

    {
        int i = nums.size() - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) // find the first decreasing number from the end
            i--;
        if (i >= 0)
        {
            int j = nums.size() - 1;
            while (j >= 0 && nums[j] <= nums[i]) // find the first number larger than nums[i] from the end
                j--;
            swap(nums[i], nums[j]); // swap nums[i] and nums[j] to get the next permutation
        }
        reverse(nums.begin() + i + 1, nums.end()); // reverse the sequence from nums[i+1] to the end
    }
};

int main()
{
    Solution s;
    vector<int> nums = {1, 2, 3};
    s.nextPermutation(nums);
    for (auto i : nums)
        cout << i << " ";
    cout << endl;
    return 0;
}