#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <sstream>

using namespace std;

int main()
{
    string file_name;
    cout << "Enter the file name: ";
    cin >> file_name;
    ifstream file(file_name);

    if (!file.is_open())
    {
        cout << "File not found" << endl;
        return 0;
    }

    string line;
    vector<vector<string>> data;

    while (getline(file, line))
    {
        stringstream ss(line);
        string word;
        vector<string> row;
        while (getline(ss, word, ','))
        {
            row.push_back(word);
        }
        data.push_back(row);
    }

    // Search in the data

    string search;
    string search_col;
    cout << "Enter the column name to search: ";
    cin >> search_col;

    int col = -1;
    for (int i = 0; i < data[0].size(); i++)
    {
        if (data[0][i] == search_col)
        {
            col = i;
            break;
        }
    }

    if (col == -1)
    {
        cout << "Column not found" << endl;
        return 0;
    }

    cout << "Enter the search string: ";
    cin >> search;

    int i = 1;
    for (i = 1; i < data.size(); i++)
    {
        if (data[i][col] == search)
        {
            for (int j = 0; j < data[i].size(); j++)
            {
                // cout << data[0][j] << ": " << data[i][j] << endl;
                cout << data[i][j] << " ";
            }
            cout << endl;
        }
    }

    if (i == data.size())
    {
        cout << "Entry Not found" << endl;
    }

    return 0;
}