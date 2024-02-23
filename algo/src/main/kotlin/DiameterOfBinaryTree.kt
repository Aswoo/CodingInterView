import utils.TreeNode
import kotlin.math.max

fun diameterOfBinaryTree(treeNode: TreeNode) : Int {

    var longest = 0
    if(treeNode == null) return -1

    fun dfs(treeNode: TreeNode, path: Int) {
        if (treeNode.left == null && treeNode.right == null) {
            longest = max(longest, path + 1)
            return
        }
        if (treeNode.left != null) dfs(treeNode.left!!, path + 1)
        if (treeNode.right != null) dfs(treeNode.right!!, path + 1)
    }
    dfs(treeNode,0)
    return longest
}

fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(6)
    root.left!!.left = TreeNode(4)
    root.left!!.right = TreeNode(5)

    println(diameterOfBinaryTree(root))
}