import utils.TreeNode

fun binarySearchTreeToGreaterSumTree() {

    fun cal(node: TreeNode?): Int {
        if (node == null) return 0
        val right = node.right
        if (right != null) {
            node.value += cal(node.right)
        }
        return node.value
    }

}
