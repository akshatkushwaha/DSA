#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;

// Solutions Copied from leetcode for better understanding
// Solution 1: Trie
// https://leetcode.com/appu_23/

// class node
// {
// public:
//     char data;
//     unordered_map<char, node *> children;
//     int idx;
//     node(char c)
//     {
//         data = c;
//         idx = -1;
//     }
// };
// class WordFilter
// {
// public:
//     node *root = new node('/0');
//     void insert(string s, int i)
//     {
//         node *curr = root;
//         for (char &ch : s)
//         {
//             if (curr->children.count(ch) == 0)
//             {
//                 node *temp = new node(ch);
//                 temp->idx = i;
//                 curr->children[ch] = temp;
//                 curr = curr->children[ch];
//             }
//             else
//             {
//                 curr->children[ch]->idx = i;
//                 curr = curr->children[ch];
//             }
//         }
//     }
//     WordFilter(vector<string> &words)
//     {
//         for (int i = 0; i < words.size(); i++)
//         {
//             string s = words[i];
//             string temp = "#";
//             temp += s;
//             for (int j = s.size() - 1; j >= 0; j--)
//             {
//                 char ch = s[j];
//                 temp = ch + temp;
//                 insert(temp, i);
//             }
//         }
//     }

//     int f(string prefix, string suffix)
//     {
//         string s = suffix + "#" + prefix;
//         int ans = -1;
//         node *curr = root;
//         for (char &ch : s)
//         {
//             if (curr->children.count(ch) == 0)
//             {
//                 return -1;
//             }
//             else
//             {
//                 ans = curr->children[ch]->idx;
//                 curr = curr->children[ch];
//             }
//         }
//         return ans;
//     }
// };

// int main()
// {
//     vector<string> words = {"abc", "deq", "mee", "aqq", "dkd", "ccc"};
//     WordFilter wf(words);
//     cout << wf.f("cd", "b") << endl;
//     cout << wf.f("cd", "ab") << endl;
//     cout << wf.f("cd", "bc") << endl;
//     return 0;
// }

// -----------------------------------------------------------------------------------------------------

// Solution 2: Trie
// https://leetcode.com/devanshu171/

class WordFilter
{
public:
    struct Node
    {
        Node *links[26];
        vector<int> indices;

        bool containsKey(char ch)
        {
            return (links[ch - 'a'] != NULL);
        }

        void put(char ch, Node *node)
        {
            links[ch - 'a'] = node;
        }

        Node *get(char ch)
        {
            return links[ch - 'a'];
        }
        void setEnd()
        {
            // flag=true;
        }
    };

    class Trie
    {
    private:
        Node *root;

    public:
        Trie()
        {
            root = new Node();
        }

        void insert(string s, int ind)
        {
            Node *node = root;
            for (int i = 0; i < s.size(); i++)
            {
                char ch = s[i];
                if (!node->containsKey(ch))
                {
                    node->put(ch, new Node());
                }
                node->indices.push_back(ind);
                node = node->get(ch);
            }
            node->indices.push_back(ind);
        }
        vector<int> search(string prefix, string suffix)
        {
            Node *node = root;
            for (int i = 0; i < prefix.size(); i++)
            {
                if (!node->containsKey(prefix[i]))
                    return {};
                node = node->get(prefix[i]);
            }
            return node->indices;
        }
    };
    Trie t;
    vector<string> ws;
    WordFilter(vector<string> &words)
    {
        for (int i = 0; i < words.size(); i++)
        {
            t.insert(words[i], i);
        }
        ws = words;
    }

    int f(string prefix, string suffix)
    {

        vector<int> indi = t.search(prefix, suffix);

        for (int i = indi.size() - 1; i >= 0; i--)
        {
            int j = suffix.size() - 1, k = ws[indi[i]].size() - 1;
            while (j >= 0 && k >= 0 && suffix[j] == ws[indi[i]][k])
            {
                k--;
                j--;
            }
            if (j == -1)
                return indi[i];
        }
        return -1;
    }
};

int main()
{
    vector<string> words = {"abc", "deq", "mee", "aqq", "dkd", "ccc"};
    WordFilter wf(words);
    cout << wf.f("cd", "b") << endl;
    cout << wf.f("cd", "ab") << endl;
    cout << wf.f("cd", "bc") << endl;
    return 0;
}