#include <bits/stdc++.h>

using namespace std;

int getNumberofDroppedPackets(vector<vector<int>> req, int max_pakts, int rates)
{
    int n = req.size();
    vector<vector<int>> dp(n, vector<int>(n, 0));

    for (int len = 1; len <= n; len++)
    {
        for (int i = 0; i + len - 1 < n; i++)
        {
            int j = i + len - 1;
            int left = (i + 2 <= j) ? dp[i + 2][j] : 0;
            int diagonal = (i + 1 <= j - 1) ? dp[i + 1][j - 1] : 0;
            int right = (i <= j - 2) ? dp[i][j - 2] : 0;

            dp[i][j] = max(req[i] + min(left, diagonal), req[j] + min(diagonal, right));
        }
    }

    return dp[0][n - 1];
}

int main()
{
    vector<vector<int>> requests = {{1, 5}, {2, 7}, {4, 3}, {6, 2}};
    int max_packets = 8;
    int rate = 3;

    int dropped_packets = getNumberofDroppedPackets(requests, max_packets, rate);

    cout << "Total number of dropped packets: " << dropped_packets << endl;

    return 0;
}