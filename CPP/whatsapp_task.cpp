#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
using namespace std;

int main()
{
    srand(time(0));

    struct point
    {
        int x, y;
    };

    struct rect
    {
        float length, breadth;
        struct point p[4];
        struct point c[100];
        int rndm;

        void
        displayInfo(float len, float bd, int blx, int bly)
        {
            p[0].x = blx;
            p[0].y = bly;
            p[1].x = blx + len;
            p[1].y = bly;
            p[2].x = blx + len;
            p[2].y = bly + bd;
            p[3].x = blx;
            p[3].y = bly + bd;

            cout << "\nLength : " << len << "\nBreadth : " << bd;

            cout << "\nCoordinates of the rectangle : {\n(" << p[3].x << "," << p[3].y << ")\t(" << p[2].x << "," << p[2].y << ")\n(" << p[0].x << "," << p[0].y << ")\t(" << p[1].x << "," << p[1].y << ")\n}\n";
            return;
        }

        void genrateCoordinate(int coordCount)
        {
            cout << "\nThe Coordinates are :\n";
            while (coordCount--)
            {
                c[coordCount].x = rand() % p[1].x + p[0].x;
                c[coordCount].y = rand() % p[2].y + p[0].y;
                cout << "( " << c[coordCount].x << "," << c[coordCount].y << " )\t";
            }
            return;
        }

        void splitRect()
        {
            float len = length / 2;
            float wid = breadth / 2;
            cout << "\n\nInformation of 1st Rectangle:\n";
            displayInfo(len, wid, p[0].x, p[0].y);
            calMean(len, wid, rndm);

            cout << "\nInformation of 2nd Rectangle:\n";
            displayInfo(len, wid, p[0].x + len, p[0].y);
            calMean(len, wid, rndm);

            cout << "\nInformation of 3rd Rectangle:\n";
            displayInfo(len, wid, p[0].x, p[0].y + wid);
            calMean(len, wid, rndm);

            cout << "\nInformation of 4th Rectangle:\n";
            displayInfo(len, wid, p[0].x - len, p[0].y);
            calMean(len, wid, rndm);
            return;
        }

        void calMean(float len, float width, int count)
        {
            float pointcount = 0, sumx = 0, sumy = 0;
            cout << "\nPoints in this Rectangle: \t";
            while (count--)
            {
                if ((c[count].x >= p[0].x && c[count].x <= p[1].x) && (c[count].y >= p[0].y && c[count].y <= p[2].y))
                {
                    pointcount += 1;
                    cout << "( " << c[count].x << "," << c[count].y << " )";
                    sumx += c[count].x;
                    sumy += c[count].y;
                }
            }
            if (pointcount == 0)
            {
                cout << "\nNo points in this Rectangle\n";
                return;
            }
            cout << "\nMean of points in this Rectangle: (" << sumx / pointcount << "," << sumy / pointcount << ")";
            cout << "\n-------------------------------------------\n";
            return;
        }
    };
    rect r;

    cout << "\n\nEnter Length: ";
    cin >> r.length;
    cout << "Enter Breadth: ";
    cin >> r.breadth;
    cout << "Enter bottom-left corner (x space y): ";
    cin >> r.p[0].x >> r.p[0].y;
    cout << "\nInformation of the rectangle: ";
    r.displayInfo(r.length, r.breadth, r.p[0].x, r.p[0].y);

    cout << "\nEnter the number of Random Coordinate: ";
    cin >> r.rndm;
    r.genrateCoordinate(r.rndm);
    r.splitRect();

    return 0;
}