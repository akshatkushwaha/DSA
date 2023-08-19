import java.util.*;

public class Solution {
    public boolean isValid(ArrayList<Pair<Integer, Integer>> queens) {
        for (int i = 0; i < queens.size(); i++) {
            for (int j = i + 1; j < queens.size(); j++) {
                if (queens.get(i).first.equals(queens.get(j).first) || queens.get(i).second.equals(queens.get(j).second)
                        ||
                        Math.abs(queens.get(i).first - queens.get(j).first) == Math
                                .abs(queens.get(i).second - queens.get(j).second)) {
                    return false;
                }
            }
        }
        return true;
    }

    public String solve(ArrayList<Pair<Integer, Integer>> queens) {
        if (isValid(queens)) {
            return "true";
        }
        for (int i = 0; i < queens.size(); i++) {
            for (int j = i + 1; j < queens.size(); j++) {
                if (queens.get(i).first.equals(queens.get(j).first) || queens.get(i).second.equals(queens.get(j).second)
                        ||
                        Math.abs(queens.get(i).first - queens.get(j).first) == Math
                                .abs(queens.get(i).second - queens.get(j).second)) {
                    return "(" + queens.get(i).first + "," + queens.get(i).second + "),(" + queens.get(j).first + ","
                            + queens.get(j).second + ")";
                }
            }
        }
        return "true";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Pair<Integer, Integer>> queens = new ArrayList<>();
        int lines = 8;
        while (lines-- > 0 && scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.isEmpty()) {
                break;
            }
            int y = Integer.parseInt(line.substring(1, line.indexOf(',')));
            int x = Integer.parseInt(line.substring(line.indexOf(',') + 1, line.length() - 1));
            queens.add(new Pair<>(y, x));
        }

        Solution s = new Solution();
        System.out.println(s.solve(queens));
    }
}
