#include <iostream>
#include <vector>

using namespace std;

class Solution
{
public:
    void setZeros(vector<vector<int>> &matrix)
    {
        int rows = matrix.size();
        int cols = matrix[0].size();
        vector<int> row(rows, 0);
        vector<int> col(cols, 0);
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                if (matrix[i][j] == 0)
                {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }
        for (int i = 0; i < rows; i++)
        {
            if (row[i] == 1)
            {
                for (int j = 0; j < cols; j++)
                {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = 0; j < cols; j++)
        {
            if (col[j] == 1)
            {
                for (int i = 0; i < rows; i++)
                {
                    matrix[i][j] = 0;
                }
            }
        }
    }
};

class Print
{
public:
    void printMatrix(vector<vector<int>> &matrix)
    {
        for (auto &row : matrix)
        {
            for (auto &col : row)
            {
                cout << col << "\t";
            }
            cout << endl;
        }
        cout << endl;
    }
};

int main()
{
    Print p;
    Solution s;

    vector<vector<int>> matrix = {
        {0, 1, 2, 0},
        {3, 4, 5, 2},
        {1, 3, 1, 5}};

    s.setZeros(matrix);

    p.printMatrix(matrix);

    return 0;
}