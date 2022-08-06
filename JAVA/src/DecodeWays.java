import java.util.ArrayList;
import java.util.HashMap;

public class DecodeWays {
    static class Solution {
        private final HashMap<Integer, String> map = new HashMap<>();

        public ArrayList<String> numDecodings(int num) {
            ArrayList<String> result = new ArrayList<>();
            ArrayList<String> result2 = new ArrayList<>();
            String query = String.valueOf(num);
            for (int i = 0; i < 26; ++i) {
                map.put(i + 1, String.valueOf((char) (i + 'a')));
                map.put(i + 27, String.valueOf((char) (i + 'A')));
            }

            ArrayList<StringBuilder> answer = helper(query);
            ArrayList<StringBuilder> answer2 = new ArrayList<>();

            helper2(query, new StringBuilder(), answer2);

            for (StringBuilder ans : answer)
                result.add(ans.toString());

            for (StringBuilder ans : answer2)
                result2.add(ans.toString());

            return result2;
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

        private void helper2(String query, StringBuilder result, ArrayList<StringBuilder> results) {
            if (query.length() == 0) {
                results.add(result);
                return;
            }
            if (query.length() == 1) {
                helper2(query.substring(1), result.append(map.get(Integer.parseInt(query))), results);
                return;
            }

            for (int i = 0; i < 2; ++i) {
                int number = Integer.parseInt(query.substring(0, i + 1));
                if (number <= 52) {
                    helper2(query.substring(i + 1), new StringBuilder(result + map.get(number)), results);
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ArrayList<String> result = s.numDecodings(1523);

        for (String str : result)
            System.out.println(str);
    }
}
