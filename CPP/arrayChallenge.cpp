#include <iostream>
#include <sstream>
#include <string>
#include <vector>

using namespace std;

/*
Have the function ArrayChallenge(strArr) read the array of strings stored in
strArr, which will contain 2 elements: the first element will be a sequence of
characters, and the second element will be a long string of comma-separated
words, in alphabetical order, that represents a dictionary of some arbitrary
length. For example: strArr can be: ["hellocat", "apple,bat,cat,goodbye,hello,yellow,why"].
Your goal is to determine if the first element in the input can be split into
two words, where both words exist in the dictionary that is provided in the
second input. In this example, the first element can be split into two words:
hello and cat because both of those words are in the dictionary.
*/

vector<string> split(string str, char delimiter) {
    vector<string> internal;
    stringstream ss(str);
    string tok;

    while (getline(ss, tok, delimiter)) {
        internal.push_back(tok);
    }

    return internal;
}

string ArrayChallenge(string strArr[], int arrLength) {
    string firstWord = strArr[0];
    string dictionary = strArr[1];
    string result = "not possible";

    vector<string> words = split(dictionary, ',');

    for (int i = 0; i < words.size(); i++) {
        string word = words[i];
        int wordLength = word.length();

        if (firstWord.substr(0, wordLength) == word) {
            string secondWord = firstWord.substr(wordLength, firstWord.length() - wordLength);

            for (int j = 0; j < words.size(); j++) {
                if (secondWord == words[j]) {
                    result = word + "," + secondWord;
                    return result;
                }
            }
        }
    }

    return result;
}

int main(void) {
    string strArr[]{"baseball", "a,all,b,ball,bas,base,cat,code,d,e,quit,z"};

    string answer = ArrayChallenge(strArr, sizeof(strArr) / sizeof(strArr[0]));

    cout << answer << endl;
}