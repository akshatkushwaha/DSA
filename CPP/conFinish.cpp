#include <iostream>
#include <vector>
#include <stack>
#include <queue>

using namespace std;

// Leetcode 207. Course Schedule

class Solution
{
public:
    bool canFinish(int numCourses, vector<vector<int>> &prerequisites)
    {
        vector<vector<int>> adj(numCourses, vector<int>());
        vector<int> degree(numCourses, 0);
        for (auto &p : prerequisites)
        {
            adj[p[1]].push_back(p[0]);
            degree[p[0]]++;
        }

        queue<int> q;
        for (int i = 0; i < numCourses; i++)
            if (degree[i] == 0)
                q.push(i);

        while (!q.empty())
        {
            int curr = q.front();
            q.pop();
            numCourses--;
            for (auto next : adj[curr])
                if (--degree[next] == 0)
                    q.push(next);
        }

        return numCourses == 0;
    }
};

int main()
{
    int numCourses = 5;
    vector<vector<int>> prerequisites = {{1, 4}, {2, 4}, {3, 1}, {3, 2}};

    Solution s;
    cout << s.canFinish(numCourses, prerequisites) << endl;

    return 0;
}