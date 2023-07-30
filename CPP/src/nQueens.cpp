#include <iostream>
#include <vector>
using namespace std;

class Solution
{
public:
    vector<vector<string>> solveNQueens(int n)
    {
        vector<vector<string>> res;
        vector<string> board(n, string(n, '.'));
        solveNQueens(res, board, 0);
        return res;
    }

    void solveNQueens(vector<vector<string>> &res, vector<string> &board, int row)
    {
        if (row == board.size())
        {
            res.push_back(board);
            return;
        }
        for (int col = 0; col < board.size(); col++)
        {
            if (isValid(board, row, col))
            {
                board[row][col] = 'Q';
                solveNQueens(res, board, row + 1);
                board[row][col] = '.';
            }
        }
    }

    bool isValid(vector<string> &board, int row, int col)
    {
        for (int i = 0; i < row; i++)
        {
            if (board[i][col] == 'Q')
                return false;
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
        {
            if (board[i][j] == 'Q')
                return false;
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.size(); i--, j++)
        {
            if (board[i][j] == 'Q')
                return false;
        }
        return true;
    }
};

int main()
{
    Solution s;
    vector<vector<string>> res = s.solveNQueens(4);
    for (auto &i : res)
    {
        for (auto &j : i)
        {
            cout << j << endl;
        }
        cout << "-------------\n";
    }
    return 0;
}