package utils

class TrieNode {
    var word: Boolean = false

    val children: Array<TrieNode?> = arrayOfNulls(26)
}

class Trie {
    var root: TrieNode = TrieNode()

    fun insert(word: String) {
        var cur: TrieNode = root
        for (c in word) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = TrieNode()
            }
            cur = cur.children[c - 'a']!!
        }
        cur.word = true
    }

    fun search(word: String): Boolean {
        var cur: TrieNode = root

        for (c in word) {
            if (cur.children[c - 'a'] == null) {
                return false
            }
            cur = cur.children[c - 'a']!!
        }
        return cur.word
    }

    fun startWith(prefix: String): Boolean {
        var cur: TrieNode = root
        for (c in prefix) {
            if(cur.children[c - 'a'] == null){
                return false
            }
            cur = cur.children[c - 'a']!!
        }
        return true
    }
}