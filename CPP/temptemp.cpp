#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <sstream>
#include <filesystem>
#include <map>

using namespace std;
// namespace fs = std::filesystem;

int main()
{
    // string path = "/home/dwh/tbt-ncash-str1/";
    // for (const auto &entry : fs::directory_iterator(path))
    //     std::cout << entry.path() << std::endl;

    // string fname = "/home/dwh/tbt-ncash-str1/DUMP_20221011_090828.DAT";
    string fname = "security.txt";
    fstream file(fname, ios::in);

    vector<vector<string>> content;
    vector<string> row;
    string line, word;

    if (!file.is_open())
    {
        cout << "Could not open the file\n";
    }

    else
    {
        while (getline(file, line))
        {
            row.clear();

            stringstream str(line);

            while (getline(str, word, '|'))
                row.push_back(word);
            content.push_back(row);
        }
    }

    fstream file1("securityonly.json", ios::out);

    file << "{\n";

    for (int i = 0; i < content.size(); i++)
    {
        file1 << '"' + content[i][0] + '"' + ": " + '"' + content[i][1] + '"' + "\n";
    }

    file1 << "}";

    return 0;
}