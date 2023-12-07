import java.util.*;

/* Konan is an origamist. Origami is the art of folding paper, and an origamist is a person who practices origami.
She is currently working on an origami character-making tutorial, where she needs to draw figures to represent each folding step.
The sheet will be in square shaped and will be placed on origin towards the first quadrant.
Initially, she will draw a line on the origami sheet. This is called as "folding line" through which the paper is going to get folded.
Imagine walking along the folding line from starting point to ending point. Split the regions into left and right side regions.
The left side region of the folding line will always fold onto the right side region.
The folding line will always separate the sheet into two regions.
The sheet will be having four corners initially. A corner is basically a point where two adjacent sides of the given figure meets.
After folding the paper along the folding line, you will get a new polygon. Given the area of the sheet and the coordinates of the folding line,
your task is to print all the coordinates of the corners of the folded sheet,(resulting polygon).
Ensure the points are printed in the clock wise direction starting from the origin.
*/

public class FoldedArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        int area = scanner.nextInt();
//
//        int x1 = scanner.nextInt();
//        int y1 = scanner.nextInt();
//
//        int x2 = scanner.nextInt();
//        int y2 = scanner.nextInt();

        int area = 4;
        int x1 = 0;
        int y1 = 1;
        int x2 = 1;
        int y2 = 2;

        printCorners(area, x1, y1, x2, y2);

        scanner.close();
    }

    private static void printCorners(int area, int x1, int y1, int x2, int y2) {

    }
}