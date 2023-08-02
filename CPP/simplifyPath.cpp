#include <iostream>
#include <vector>
#include <string>
#include <deque>

using namespace std;

class Solution
{
public:
    string simplifyPath(string path)
    {
        deque<string> pathQueue;
        string result;
        int i = 0;

        while (i < path.length())
        {
            if (path[i] == '/')
            {
                int j = i + 1;
                string temp;
                while (j < path.length() && path[j] != '/')
                {
                    temp += path[j];
                    ++j;
                }
                i = j;
                if (temp == "." || temp.length() == 0)
                    continue;
                else if (temp == "..")
                {
                    if (!pathQueue.empty())
                        pathQueue.pop_back();
                }
                else
                    pathQueue.push_back(temp);
            }
        }

        while (!pathQueue.empty())
        {
            result += "/" + pathQueue.front();
            pathQueue.pop_front();
        }

        return (result.length() == 0) ? "/" : result;
    }
};

int main()
{
    Solution s;
    vector<string> querys = {"/home/", "/../", "/home//foo/", "/a//b////c/d//././/.."};
    for (string path : querys)
    {
        string result = s.simplifyPath(path);
        cout << result << endl;
    }
    return 0;
}