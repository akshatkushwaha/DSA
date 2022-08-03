import java.util.*;

public class CourseSchedule {
    public static void main(String[] args) {

        int numCourses = 20;
        int[][] prerequisites = {{0, 10}, {3, 18}, {5, 5}, {6, 11}, {11, 14}, {13, 1}, {15, 1}, {17, 4}};

        System.out.println(canFinish(numCourses, prerequisites));
    }

    static Map<Integer, List<Integer>> map = new HashMap<>();
    static Set<Integer> visited = new HashSet<>();

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int[] prerequisite : prerequisites)
            map.put(prerequisite[0], new ArrayList<>());

        for (int[] pre : prerequisites)
            map.get(pre[0]).add(pre[1]);

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i))
                return false;
        }
        return true;
    }

    public static boolean dfs(int course) {
        if (visited.contains(course))
            return false;
        if (map.get(course) == null)
            return true;

        visited.add(course);
        List<Integer> dependCourses = map.get(course);
        for (int dCourse : dependCourses) {
            if (!dfs(dCourse))
                return false;
        }
        map.get(course).clear();
        visited.remove(course);
        return true;
    }

}