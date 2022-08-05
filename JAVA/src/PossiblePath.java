import java.util.ArrayList;
import java.util.Stack;

public class PossiblePath {
    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {{0, 1}, {0, 2}, {3, 5}, {5, 4}, {3, 4}, {1, 3}};
        int source = 0;
        int destination = 5;

        System.out.println(validPath(n, edges, source, destination));
    }

    static boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean[] visited = new boolean[n];
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            adjList.add(new ArrayList<>());
            visited[i] = false;
        }

        for (int[] pair : edges) {
            adjList.get(pair[0]).add(pair[1]);
            adjList.get(pair[1]).add(pair[0]);
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(source);

        while (!stack.empty()) {
            int current = stack.pop();
            visited[current] = true;

            if (current == destination)
                return true;

            for (int neighbour : adjList.get(current))
                if (!visited[neighbour]) stack.push(neighbour);
        }

        return false;
    }
}
