package DataStructures.Trie;

// https://leetcode.com/problems/add-and-search-word-data-structure-design/
public class WordDictionary {
    class TrieNode {
        String val;
        TrieNode[] next;

        TrieNode() {
            this.next = new TrieNode[26];
        }
    }

    TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }

    private int getCharCode(char c) {
        return c % 26;
    }

    private TrieNode getNext(TrieNode node, char c) {
        return node.next[getCharCode(c)];
    }

    private void setNext(TrieNode node, char c, TrieNode newNode) {
        node.next[getCharCode(c)] = newNode;
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;

        for (char c : word.toCharArray()) {
            TrieNode next = getNext(node, c);

            if (next == null) {
                setNext(node, c, new TrieNode());
                node = getNext(node, c);
            } else {
                node = next;
            }
        }

        node.val = word;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return match(word.toCharArray(), 0, root);
    }

    private boolean match (char[] word, int k, TrieNode node) {
        if (k >= word.length) {
            return node.val != null;
        }

        char c = word[k];

        if (c != '.') {
            TrieNode next = getNext(node, c);

            if (next != null) {
                return match(word, k + 1, next);
            }
        } else {
            for (int i = 0; i < 26; i++) {
                TrieNode next = node.next[i];

                if (next != null && match(word, k + 1, next)) {
                    return true;
                }
            }
        }

        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
