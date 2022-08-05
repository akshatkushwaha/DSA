import java.util.ArrayList;

public class FindCenterOfStarGraph {
    public static void main(String[] args) {
        int[][] edges = {{1, 2}, {5, 1}, {1, 3}, {1, 4}};
        System.out.println(findCenter(edges));
    }

    static int findCenter(int[][] edges) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= edges.length + 1; ++i) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        int center = 0;
        for (int i = 0; i < adjList.size(); ++i)
            center = (adjList.get(i).size() > adjList.get(center).size()) ? i : center;

        return center;
    }
}
