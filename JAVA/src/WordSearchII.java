import java.util.ArrayList;
import java.util.List;

public class WordSearchII {
    public static void main(String[] args) {
        String[][] boardInString = new String[][]{{"o", "a", "a", "n"}, {"e", "t", "a", "e"}, {"i", "h", "k", "r"}, {"i", "f", "l", "v"}};
        String[] words = new String[]{"oath", "pea", "eat", "rain"};
        char[][] board = new char[boardInString.length][boardInString[0].length];

        for (int i = 0; i < boardInString.length; ++i) {
            for (int j = 0; j < boardInString[i].length; ++j) {
                board[i][j] = boardInString[i][j].charAt(0);
            }
        }

        List<String> foundWords = findWords(board, words);

        System.out.println(foundWords);
    }

    protected static List<String> findWords(char[][] board, String[] words) {
        List<String> foundWords = new ArrayList<>();

        for (String word : words) {
            boolean found = false;
            for (int i = 0; i < board.length && !found; ++i) {
                for (int j = 0; j < board[i].length && !found; ++j) {
                    if (board[i][j] == word.charAt(0) && bfs(board, word, i, j)) {
                        foundWords.add(word);
                        found = true;
                    }
                }
            }
        }

        return foundWords;
    }

    protected static boolean bfs(char[][] board, String word, int x, int y) {
        if (word.length() == 0) {
            return true;
        }

        if (x < 0 || x >= board.length || y < 0 || y >= board[x].length || board[x][y] != word.charAt(0)) {
            return false;
        }

        char temp = board[x][y];
        board[x][y] = ' ';

        boolean found = bfs(board, word.substring(1), x + 1, y) ||
                bfs(board, word.substring(1), x - 1, y) ||
                bfs(board, word.substring(1), x, y + 1) ||
                bfs(board, word.substring(1), x, y - 1);

        board[x][y] = temp;

        return found;
    }
}
