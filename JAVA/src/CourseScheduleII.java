import java.util.Arrays;

public class CourseScheduleII {
    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};

        int[] order = findOrder(numCourses, prerequisites);

        System.out.println(Arrays.toString(order));
    }

    protected static int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        boolean[] visited = new boolean[prerequisites.length];
        boolean[] done = new boolean[numCourses];
        int[] res = new int[numCourses];

        for (int[] p : prerequisites) {
            indegree[p[1]]++;
        }
        int index = 0;
        boolean hasNewVertex = true;
        while (hasNewVertex) {
            hasNewVertex = false; // only update this flag until new vertex is found
            for (int i = 0; i < prerequisites.length; i++) {
                if (!visited[i]) {
                    int cur = prerequisites[i][0];
                    int pre = prerequisites[i][1];
                    if (indegree[cur] == 0) {
                        // start from indegree == 0, cut edges, until no indegree = 0
                        visited[i] = true;
                        indegree[pre]--;
                        hasNewVertex = true;
                        if (!done[cur]) {
                            done[cur] = true;
                            res[index++] = cur;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < numCourses; i++) {
            if (!done[i]) {
                res[index++] = i;
            }
        }

        for (int i = 0; i < numCourses / 2; i++) {
            int temp = res[i];
            res[i] = res[numCourses - 1 - i];
            res[numCourses - 1 - i] = temp;
        }

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] != 0) {
                return new int[]{};
            }
        }


        return res;
    }
}
