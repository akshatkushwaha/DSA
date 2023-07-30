#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution
{
public:
    int searchRow(vector<int> &matrix, int target)
    {
        int start = 0;
        int end = matrix.size();
        while (start <= end)
        {
            int mid = start + (end - start) / 2;
            if (matrix[mid] == target)
                return mid;
            else if (matrix[mid] < target)
                start = mid + 1;
            else
                end = mid - 1;
        }

        return -1;
    }

    vector<int> searchMatrix(vector<vector<int>> &matrix, int target)
    {
        int rows = matrix.size();
        int cols = matrix[0].size();
        int start = 0;
        int end = rows - 1;
        while (start <= end)
        {
            int mid = start + (end - start) / 2;

            if (matrix[mid][0] > target)
                end = mid - 1;
            else if (matrix[mid][cols - 1] < target)
                start = mid + 1;
            else
            {
                int col = searchRow(matrix[mid], target);
                if (col == -1)
                    return {-1, -1};
                return {mid, col};
            }
        }

        return {-1, -1};
    }
};

int main()
{
    Solution s;

    vector<vector<int>> matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
    vector<int> coordinates = s.searchMatrix(matrix, 5);

    for (int coordinate : coordinates)
        cout << coordinate << " ";
    cout << endl;

    return 0;
}