import utils.TreeNode

fun convertedSortedArrayToBinarySearchTree(nums: IntArray): TreeNode? {
    fun constructor(lo: Int, hi: Int): TreeNode {
        val mid = (lo + hi) / 2
        val node = TreeNode(nums[mid])
        node.left = constructor(lo, mid - 1)
        node.right = constructor(mid + 1, hi)

        return node
    }

    return if (nums.isEmpty()) null else constructor(0, nums.size - 1)
}