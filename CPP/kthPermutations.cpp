#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

class Solution
{
public:
    int fact(int n)
    {
        if (n == 0)
            return 1;
        return n * fact(n - 1);
    }

    string getPermutation(int n, int k)
    {
        vector<int> nums;
        for (int i = 1; i <= n; i++)
            nums.push_back(i);
        string res = "";
        k--;
        while (n > 0)
        {
            int index = k / fact(n - 1);      // index of the last digit in the permutation
            res += to_string(nums[index]);    // add the last digit to the result string and remove it from the nums vector to avoid duplicates
            nums.erase(nums.begin() + index); // remove the last digit from the list of available digits
            k %= fact(n - 1);                 // update the remaining number of permutations
            n--;                              // update n to the number of digits left to be permuted
        }
        return res;
    }
};

int main()
{
    Solution s;
    cout << s.getPermutation(6, 380) << endl;
    return 0;
}