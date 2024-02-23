package utils

data class TreeNode(
    var value: Int = 0, // avoid the val keyword
    var left: TreeNode? = null,
    var right: TreeNode? = null
)