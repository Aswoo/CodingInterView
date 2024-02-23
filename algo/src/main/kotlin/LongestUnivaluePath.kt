import utils.TreeNode
import kotlin.math.max

fun longestUnivaluePath(treeNode: TreeNode): Int {

    var longest = 0
    fun dfs(treeNode: TreeNode?): Int {

        if (treeNode == null) return 0

        var left = dfs(treeNode.left)
        var right = dfs(treeNode.right)

        if (treeNode.left != null && treeNode.left!!.value == treeNode.value) {
            left += 1
        } else left = 0

        if (treeNode.right != null && treeNode.right!!.value == treeNode.value) {
            right += 1
        } else right = 0

        longest = max(longest, left + right)

        return max(left, right)
    }
    dfs(treeNode)
    return longest
}

fun main() {

}