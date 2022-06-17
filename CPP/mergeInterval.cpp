#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    void showVector(vector<vector<int>> &v)
    {
        for (auto &i : v)
        {
            cout << i[0] << " " << i[1] << endl;
        }
        cout << endl;
    }

    vector<vector<int>> merge(vector<vector<int>> &intervals)
    {
        std::sort(intervals.begin(), intervals.end(), [](vector<int> &a, vector<int> &b)
                  { return a[0] < b[0]; });
        vector<vector<int>> res;
        res.push_back(intervals[0]);
        for (int i = 1; i < intervals.size(); ++i)
        {
            if (intervals[i][0] <= res.back()[1])
            {
                int a = res.back()[0];
                vector<int> temp;
                temp.push_back(a);
                if (intervals[i][1] < res.back()[1])
                {
                    temp.push_back(res.back()[1]);
                }
                else
                {
                    temp.push_back(intervals[i][1]);
                }
                res.pop_back();
                res.push_back(temp);
            }
            else
            {
                res.push_back(intervals[i]);
            }
        }

        return res;
    }
};

int main()
{
    Solution s;
    // vector<vector<int>> intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
    vector<vector<int>> intervals = {{2, 3}, {4, 5}, {6, 7}, {8, 9}, {1, 10}};
    vector<vector<int>> res = s.merge(intervals);
    s.showVector(res);
    return 0;
}