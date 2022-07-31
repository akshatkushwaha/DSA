import java.util.*;

class WordFilter {
    String[] input;
    TrieNode dict;

    public WordFilter(String[] words) {
        this.input = words;
        this.dict = new TrieNode();
        for (int wi = 0; wi < words.length; wi++) {
            insert(words[wi], dict, wi);
        }
    }

    public int f(String prefix, String suffix) {
        List<Integer> indexes = getIndexList(prefix, dict);
        if (indexes == null) {
            return -1;
        }
        for (int i = indexes.size() - 1; i >= 0; i--) {
            int idx = indexes.get(i);
            if (input[idx].endsWith(suffix)) {
                return idx;
            }
        }
        return -1;
    }

    public List<Integer> getIndexList(String word, TrieNode root) {
        for (int c = 0; c < word.length() && root != null; c++) {
            int idx = word.charAt(c) - 'a';
            root = root.childs[idx];
        }
        return root == null ? null : root.indexes;
    }

    public void insert(String word, TrieNode root, int wordIndex) {
        for (int c = 0; c < word.length(); c++) {
            int idx = word.charAt(c) - 'a';
            if (root.childs[idx] == null) {
                root.childs[idx] = new TrieNode();
            }
            // store the index of word index
            // at each node.
            root.indexes.add(wordIndex);
            root = root.childs[idx];
        }
        root.indexes.add(wordIndex);
        root.isLast = true;
    }

    class TrieNode {
        TrieNode[] childs;
        boolean isLast;
        List<Integer> indexes;

        public TrieNode() {
            this.childs = new TrieNode[26];
            this.isLast = false;
            this.indexes = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        WordFilter wf = new WordFilter(new String[] { "apple", "app", "apple", "app" });
        System.out.println(wf.f("a", "e"));
        System.out.println(wf.f("app", "le"));
        System.out.println(wf.f("ap", "ple"));
        System.out.println(wf.f("ap", "pp"));
    }
}