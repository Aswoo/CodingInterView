class SuffixTreeNode {
    val children = mutableMapOf<Char, SuffixTreeNode>()
}

class SuffixTree(private val text: String) {
    private val root = SuffixTreeNode()

    init {
        // 문자열의 모든 접미사를 트리에 추가
        for (i in text.indices) {
            insertSuffix(text.substring(i))
        }
    }

    private fun insertSu(suffix: String) {
        var currentNode = root
        for (char in suffix) {
            if(!currentNode.children.containsKey(char)){
                currentNode.children[char] = SuffixTreeNode()
            }
            currentNode = currentNode.children[char]!!
        }
    }

    private fun insertSuffix(suffix: String) {
        var currentNode = root
        for (char in suffix) {
            if (!currentNode.children.containsKey(char)) {
                currentNode.children[char] = SuffixTreeNode()
            }
            currentNode = currentNode.children[char]!!
        }
    }

    fun contains(substring: String): Boolean {
        var currentNode = root
        for (char in substring) {
            if (!currentNode.children.containsKey(char)) {
                return false
            }
            currentNode = currentNode.children[char]!!
        }
        return true
    }
}

fun main() {
    val suffixTree = SuffixTree("banana")

    // 검색
    println(suffixTree.contains("ana")) // true
    println(suffixTree.contains("xyz")) // false
}