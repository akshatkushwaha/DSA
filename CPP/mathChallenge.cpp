#include <iostream>
#include <queue>
#include <string>

using namespace std;

bool isOperator(char c) {
    return c == '+' || c == '-' || c == '*' || c == '/';
}

int performOperation(int operand1, int operand2, char op) {
    switch (op) {
    case '+':
        return operand1 + operand2;
    case '-':
        return operand1 - operand2;
    case '*':
        return operand1 * operand2;
    case '/':
        return operand1 / operand2;
    default:
        throw std::invalid_argument("Invalid operator: " + op);
    }
}

string MathChallenge(string str) {
    queue<string> tokens;

    for (int i = 0; i < str.length(); ++i) {
        if (str[i] == ' ') {
            continue;
        } else if (str[i] == '(') {
            string temp = "";
            int j = i + 1;
            while (str[j] != ')' && j < str.length()) {
                temp += str[j];
                j++;
            }
            tokens.push(MathChallenge(temp));
            tokens.push(str.substr(j + 1, 1));
            i = j + 1;
            temp = "";
        } else if (!isOperator(str[i])) {
            string temp = "";
            while (i < str.length() && !isOperator(str[i])) {
                temp += str[i];
                i++;
            }
            tokens.push(temp);
            tokens.push(str.substr(i, 1));
        }
    }

    for (int i = 0; i < tokens.size(); i++) {
        cout << tokens.front() << endl;
        tokens.pop();
    }

    return str;
}

int main() {
    string equation = "6*(4/2)+3*2";
    cout << MathChallenge(equation);
    return 0;
}