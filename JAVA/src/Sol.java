import java.util.*;
// Given an mxn grid of characters represented by the variable "board" and a string represented by the variable "word", the challenge is to find out if it is possible to construct the word by selecting letters from sequentially adjacent cells in the grid. The grid consists of m rows and n columns, and each cell in the grid can contain a single character. To be considered adjacent, two cells must share a common side (either horizontally or vertically)
// Note:
// Same letter cell may not be used more than once, inclining once a letter from a cell is used to construct the word, that cell cannot be used again. The tasks to implement a function or method that takes in these two inputs (board and ward) and turns a boolean value indicating if the word can be constructed from letters of sequentially jacent cells in the gild A return value of true would indicate that the word can be constructed and false otherwise
// In this problem you have to imply check if the men yol costs in the age of characters and whether the word can be constructed from letter of sequentially adiacens cols where admicent ele horizontally ofsertically neighboring

public class Sol {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> queens = new ArrayList<>();
        int lines = 8;
        while (lines-- > 0 && scanner.hasNextLine()) {
            String line = scanner.nextLine();

            int y = Integer.parseInt(line.substring(1, line.indexOf(',')));
            int x = Integer.parseInt(line.substring(line.indexOf(',') + 1, line.length() - 1));

            ArrayList<Integer> pair = new ArrayList<>();
            pair.add(y);
            pair.add(x);
            queens.add(pair);
        }

        System.out.println(solve(queens));
    }

    public static String solve(ArrayList<ArrayList<Integer>> queens) {
        for (int i = 0; i < queens.size(); i++) {
            for (int j = i + 1; j < queens.size(); j++) {
                if (queens.get(i).get(0).equals(queens.get(j).get(0))
                        || queens.get(i).get(1).equals(queens.get(j).get(1))
                        ||
                        Math.abs(queens.get(i).get(0) - queens.get(j).get(0)) == Math
                                .abs(queens.get(i).get(1) - queens.get(j).get(1))) {
                    return "(" + queens.get(i).get(0) + "," + queens.get(i).get(1) + "),(" + queens.get(j).get(0) + ","
                            + queens.get(j).get(1) + ")";
                }
            }
        }
        return "true";
    }
}
