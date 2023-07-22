import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlantic {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            dfs(heights, pacific, i, 0);
            dfs(heights, atlantic, i, cols - 1);
        }
        for (int i = 0; i < cols; i++) {
            dfs(heights, pacific, 0, i);
            dfs(heights, atlantic, rows - 1, i);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private void dfs(int[][] heights, boolean[][] visited, int row, int col) {
        if (visited[row][col]) {
            return;
        }
        visited[row][col] = true;
        int height = heights[row][col];
        if (row > 0 && heights[row - 1][col] >= height) {
            dfs(heights, visited, row - 1, col);
        }
        if (row < heights.length - 1 && heights[row + 1][col] >= height) {
            dfs(heights, visited, row + 1, col);
        }
        if (col > 0 && heights[row][col - 1] >= height) {
            dfs(heights, visited, row, col - 1);
        }
        if (col < heights[0].length - 1 && heights[row][col + 1] >= height) {
            dfs(heights, visited, row, col + 1);
        }
    }
}
