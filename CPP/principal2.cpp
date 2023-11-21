#include <iostream>
#include <vector>
using namespace std;
/*
    Problem Statement:
    Given a string str, determine wheather that word str is multigram and determine the first occurance from left to
    right and it is the shorted anagram. return "-1" if given word is not a multigram.
*/

string findShortestRepeatingSubstring(const string &s) {
    string result = "";

    // Iterate through potential lengths of the repeating substring
    for (int substringLength = 1; substringLength <= s.size() / 2; ++substringLength) {
        if (s.size() % substringLength != 0) {
            continue; // If the length is not a divisor, move to the next length
        }

        // Count occurrences of characters in each potential substring
        int numSubstrings = s.size() / substringLength;
        vector<vector<int>> charCounts(numSubstrings, vector<int>(26, 0));

        for (int i = 0; i < s.size(); ++i) {
            int charIndex = s[i] - 'a';
            charCounts[i / substringLength][charIndex]++;
        }

        // Check if the pattern repeats consistently
        vector<int> firstSubstringCounts = charCounts[0];
        bool patternMatches = true;

        for (int i = 1; i < numSubstrings; ++i) {
            for (int charIndex = 0; charIndex < 26; ++charIndex) {
                if (firstSubstringCounts[charIndex] != charCounts[i][charIndex]) {
                    patternMatches = false;
                    break;
                }
            }
        }

        if (patternMatches) {
            // Construct the resulting substring and return
            result = s.substr(0, substringLength);
            return result;
        }
    }

    return "-1";
}

int main() {
    vector<string> strings = {"xyyyxyyyx", "cccccc", "abcd"};
    for (string s : strings) {
        cout << findShortestRepeatingSubstring(s) << endl;
    }

    return 0;
}