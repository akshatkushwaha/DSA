import java.util.Arrays;

public class NetworkDelayTime {
    private final static int MAX = 1_000_000_000;
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] time = new int[n+1];
        Arrays.fill(time, MAX);
        time[k] = time[0] = 0; // time[0] is garbage

        for (int i = 1; i < n; i++) { // for n nodes, we iterate max n-1 times
            boolean canRelax = false;
            for (var e : times) if (time[e[0]] + e[2] < time[e[1]]) {
                time[e[1]] = time[e[0]] + e[2];
                canRelax = true;
            }
            if (!canRelax) break;
        }

        int res = time[1];
        for (var t : time) if (t == MAX) return -1; else if (t > res) res = t;
        return res;
    }
}
