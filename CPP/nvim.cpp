#include <iostream>
#include <stdio.h>
#include <vector>

using namespace std;

int main() {
  int a;
  cin >> a;

  for (int i = 0; i < a; i += a) {
    cout << i << endl;
  }

  return 0;
}
