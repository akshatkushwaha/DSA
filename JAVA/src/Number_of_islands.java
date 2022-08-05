public class Number_of_islands {
    public static void main(String[] args) {
        char[][] map = {
                {'w', 'l', 'l', 'w', 'l', 'w'},
                {'l', 'l', 'l', 'w', 'l', 'w'},
                {'w', 'l', 'w', 'w', 'w', 'w'},
                {'w', 'l', 'w', 'l', 'l', 'w'},
                {'w', 'l', 'w', 'l', 'l', 'w'},
                {'w', 'w', 'w', 'w', 'w', 'w'}
        };

        System.out.println(numberofislands(map));
    }

    private static int numberofislands(char[][] map) {
        boolean[][] visited = new boolean[map.length][map[0].length];
        int islands = 0;

        for (int row = 0; row < map.length; ++row) {
            for (int col = 0; col < map[row].length; ++col)
                visited[row][col] = false;
        }

        for (int row = 0; row < map.length; ++row) {
            for (int col = 0; col < map[row].length; ++col) {
                if (visited[row][col] || map[row][col] == 'w')
                    continue;

                dfs(row, col, map, visited);
                islands += 1;

                printVisitedMap(visited);
            }
        }

        return islands;
    }

    private static void dfs(int row, int col, char[][] map, boolean[][] visited) {
        if (row < 0 || row >= map.length
                || col < 0 || col >= map[row].length
                || visited[row][col] || map[row][col] == 'w'
        ) return;

        visited[row][col] = true;

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (int i = 0; i < 4; ++i) {
            dfs(row + directions[i][0], col + directions[i][1], map, visited);
        }
    }

    private static void printVisitedMap(boolean[][] map) {
        for (boolean[] row : map) {
            for (boolean visited : row) {
                System.out.print((visited ? 1 : "fal") + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}
