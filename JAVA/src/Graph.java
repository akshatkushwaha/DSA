import java.util.*;
import java.util.stream.Stream;

public class Graph {
    List<Node> nodes = new ArrayList<>();

    Graph(int nodesCount) {
        for (int i = 0; i < nodesCount; ++i) {
            nodes.add(new Node(String.valueOf(i)));
        }
    }

    public void caluculateShortestPath(Node source) {
        source.distance = 0;

        Set<Node> settledNodes = new HashSet<>();
        Queue<Node> unsettledNodes = new PriorityQueue<>(Collections.singleton(source));

        while (!unsettledNodes.isEmpty()) {
            Node currentNode = unsettledNodes.poll();
            currentNode.adjacentNodes
                    .entrySet()
                    .stream()
                    .filter(entry -> !settledNodes.contains(entry.getKey()))
                    .forEach(entry -> {
                                evaluateDistanceAndPath(entry.getKey(), entry.getValue(), currentNode);
                                unsettledNodes.add(entry.getKey());
                            });
            settledNodes.add(currentNode);
        }
    }

    private void evaluateDistanceAndPath(Node adjacentNode, int edgeWeight, Node sourceNode) {
        int newDistance = sourceNode.distance + edgeWeight;
        if(newDistance < adjacentNode.distance) {
            adjacentNode.distance = newDistance;
            adjacentNode.shortestPath = Stream.concat(sourceNode.shortestPath.stream(), Stream.of(sourceNode)).toList();
        }
    }

    public void printShortestPaths(){
        for (Node node : nodes) {
            StringBuilder path = new StringBuilder();
            for (Node pathNode : node.shortestPath) {
                path.append(pathNode.name).append(" -> ");
            }
            if(path.isEmpty())
                path.append("0 -> ");
            path.append(node.name);
            System.out.println(path + " : " + node.distance);
        }
    }

    public void printGraphPaths() {
        for (Node node : nodes) {
            System.out.println("From " + node.name);
            node.adjacentNodes.forEach((key, value) -> System.out.println("\t" + key.name + " : " + value));
        }
    }
}

class Node implements Comparable<Node> {
    final String name;
    int distance = Integer.MAX_VALUE;
    List<Node> shortestPath = new LinkedList<>();
    Map<Node, Integer> adjacentNodes = new HashMap<>();

    Node(String name) {
        this.name = name;
    }

    public void addAdjacentNode(Node node, int weight) {
        adjacentNodes.put(node, weight);
    }

    @Override
    public int compareTo(Node node) {
        return Integer.compare(this.distance, node.distance);
    }
}