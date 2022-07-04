#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

class Solution
{
public:
    int numTrees(int n)
    {
        if (n == 0 || n == 1 || n == 2)
            return n;
        int dp[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++)
        {
            dp[i] = 0;
            for (int j = 1; j <= i; j++)
            {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
};

int main()
{
    Solution s;

    cout << s.numTrees(3) << endl;
    cout << s.numTrees(6) << endl;
    cout << s.numTrees(8) << endl;
    cout << s.numTrees(19) << endl;

    return 0;
}