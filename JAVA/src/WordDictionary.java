class WordDictionary {
    public static class TrieNode {
        boolean word;
        TrieNode[] children = new TrieNode[26];
    }

    private TrieNode[] root = new TrieNode[26];
    private int maxDepth = 0;

    public WordDictionary() {

    }

    public void addWord(String word) {
        maxDepth = Math.max(maxDepth, word.length());
        TrieNode[] trie = root;
        TrieNode node = null;
        for (char c : word.toCharArray()) {
            node = trie[c - 'a'];
            if (node == null) {
                node = new TrieNode();
            }
            trie[c - 'a'] = node;
            trie = node.children;
        }
        node.word = true;
    }

    public boolean search(String word) {
        if (word.isEmpty() || maxDepth < word.length()) {
            return false;
        }
        return searchIn(root, 0, word);
    }

    private boolean searchIn(TrieNode[] root, int start, String word) {
        TrieNode node = null;
        for (int i = start; i < word.length(); i++) {
            if (word.charAt(i) == '.') {
                for (char letter = 'a'; letter <= 'z'; letter++) {
                    node = root[letter - 'a'];
                    if (node == null) {
                        continue;
                    }
                    if (i + 1 == word.length() && node.word) {
                        return true;
                    }
                    if (searchIn(node.children, i + 1, word)) {
                        return true;
                    }
                }
                return false;
            } else {
                node = root[word.charAt(i) - 'a'];
                if (node == null) {
                    return false;
                }
                root = node.children;
            }
        }
        return node != null && node.word;
    }
}