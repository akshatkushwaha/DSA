#include <iostream>

using namespace std;

// 3/4 of a pencil can write 4 pages
// use 4 quater piece to generate 1 pencil
// cannot use single quater pieces

int calculatePagesWritten(int pencils) {
    int quaterPiece = 0;
    int pagesWritten = 0;
    while (pencils > 0) {
        pagesWritten += pencils * 4;

        quaterPiece += pencils;
        pencils = quaterPiece / 4;
        quaterPiece = quaterPiece % 4;
        // cout << "Pencils: " << pencils << " QuaterPiece: " << quaterPiece << endl;
    }

    return pagesWritten;
}

int main() {
    int pencilsArr[] = {22, 17, 10, 47, 13};

    for (int pencils : pencilsArr) {
        cout << "Pencils: " << pencils << " Pages: " << calculatePagesWritten(pencils) << endl;
    }
    return 0;
}