import java.util.*;
import java.util.LinkedList;

enum Color {Both, Red, Blue}

class PathNode {
    int value;
    int distance;
    Color color;

    public PathNode(int value, int distance, Color color) {
        this.value = value;
        this.distance = distance;
        this.color = color;
    }

    public int getValue() {
        return value;
    }

    public int getDistance() {
        return distance;
    }

    public Color getColor() {
        return color;
    }
}

public class ShortestPathWithAlternatingColors {
    public static void main(String[] args) {
        int[][] redEdges = {{0,1},{1,2}};
        int[][] blueEdges = {};
        int n = 3;
        int[] result = new ShortestPathWithAlternatingColors().shortestAlternatingPaths(n, redEdges, blueEdges);
        System.out.println(Arrays.toString(result));
    }
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int[] result = new int[n];
        ArrayList<Map<Integer, Color>> graph = createGraph(n, redEdges, blueEdges);
        Queue<PathNode> queue = new LinkedList<>();
        queue.add(new PathNode(0, 0, Color.Both));

        while(!queue.isEmpty()) {
            PathNode node = queue.poll();
            int value = node.getValue();
            int distance = node.getDistance();
            Color color = node.getColor();
            
            for(int i = 0; i < graph.get(value).size(); i++) {
                int nextValue = (int) graph.get(value).keySet().toArray()[i];
                Color nextColor = graph.get(value).get(nextValue);
                if (nextColor == Color.Both || nextColor != color) {
                    queue.add(new PathNode(nextValue, distance + 1, nextColor));
                }
            }
        }

        return result;
        
    }

    private ArrayList<Map<Integer, Color>> createGraph(int n, int[][] redEdges, int[][] blueEdges) {
        ArrayList<Map<Integer, Color>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new HashMap<>());
        }
        for (int[] redEdge : redEdges) {
            graph.get(redEdge[0]).put(redEdge[1], Color.Red);
        }
        for (int[] blueEdge : blueEdges) {
            graph.get(blueEdge[0]).put(blueEdge[1], Color.Blue);
        }

        return graph;
    }
}
