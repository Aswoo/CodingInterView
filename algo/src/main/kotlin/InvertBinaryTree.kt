import utils.TreeNode

fun invertBinaryTree(treeNode: TreeNode) {

    fun dfs(treeNode: TreeNode?) {
        if (treeNode == null) {
            return
        }

        val left = treeNode.left
        val right = treeNode.right

        treeNode.left = right
        treeNode.right = left

        dfs(treeNode.left)
        dfs(treeNode.right)
    }

    dfs(treeNode)
}

fun main() {

    val root = TreeNode(4)
    root.left = TreeNode(5)
    root.right = TreeNode(7)

    root.left!!.left = TreeNode(1)
    root.left!!.right = TreeNode(3)

    root.right!!.left = TreeNode(6)
    root.right!!.right = TreeNode(9)

    invertBinaryTree(root)

    print(root.left)
//    print(root.left!!.left)
}