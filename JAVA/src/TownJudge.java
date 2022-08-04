import java.util.ArrayList;

public class TownJudge {
    public static void main(String[] args) {
        int n = 3;
        int[][] trust = {{1, 3}, {2, 3}, {3, 1}};

        System.out.println(findJudge(n, trust));
    }

    static int findJudge(int n, int[][] trust) {
        if (n == 1) return 1;

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        boolean[] trustNobody = new boolean[n + 1];

        for (int i = 0; i <= n; ++i) {
            adjList.add(new ArrayList<>());
            trustNobody[i] = true;
        }

        for (int[] pair : trust) {
            adjList.get(pair[1]).add(pair[0]);
            trustNobody[pair[0]] = false;
        }

        for (int i = 0; i <= n; ++i) {
            if (trustNobody[i] && adjList.get(i).size() == n - 1)
                return i;
        }

        return -1;
    }
}
