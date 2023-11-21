#include <iostream>
#include <stdio.h>
#include <vector>

using namespace std;

int main() {
    int a;
    cin >> a;

    vector<int> vec;

    for (int i = 0; i < 100; i += a) {
        cout << i << endl;

        vec.push_back(i);
    }

    return 0;
}
