import java.util.ArrayList;
import java.util.HashMap;

public class DecodeWays {
    static class Solution {
        private final HashMap<Integer, String> map = new HashMap<>();

        public ArrayList<String> numDecodings(int num) {
            ArrayList<String> result = new ArrayList<>();
            String query = String.valueOf(num);
            for (int i = 0; i < 26; ++i) {
                map.put(i + 1, String.valueOf((char) (i + 'a')));
                map.put(i + 27, String.valueOf((char) (i + 'A')));
            }

            ArrayList<StringBuilder> answer = helper(query);

            for (StringBuilder ans : answer)
                result.add(ans.toString());

            return result;
        }

        private ArrayList<StringBuilder> helper(String query) {
            ArrayList<StringBuilder> result = new ArrayList<>();
            if (query.length() == 0) {
                return new ArrayList<>();
            }
            if (query.length() == 1) {
                result.add(new StringBuilder(map.get(Integer.parseInt(query))));
                return result;
            }

            for (int i = 0; i < 2; ++i) {
                int numbers = Integer.parseInt(query.substring(0, i + 1));
                if (numbers <= 52) {
                    ArrayList<StringBuilder> temps = helper(query.substring(i + 1));
                    for (StringBuilder temp : temps) {
                        result.add(new StringBuilder(map.get(numbers)).append(temp));
                    }
                    if (temps.size() == 0)
                        result.add(new StringBuilder(map.get(numbers)));
                }
            }

            return result;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ArrayList<String> result = s.numDecodings(1523);

        for (String str : result)
            System.out.println(str);
    }
}
