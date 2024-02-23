import utils.TreeNode
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

fun balancedBinaryTree(treeNode: TreeNode): Boolean {

    fun dfs(treeNode: TreeNode?): Int {
        if (treeNode == null) {
            return 0
        }
        val right = dfs(treeNode.right)
        val left = dfs(treeNode.left)

        return if (left == -1 || right == -1 || abs(left - right) > 1) -1 else left.coerceAtLeast(right) + 1
    }
    return dfs(treeNode) != -1
}