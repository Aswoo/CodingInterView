import utils.TreeNode
import java.util.*

fun treeSerialization() {

    fun serialize(root: TreeNode?): String {
        if (root == null) return ""

        val queue: Queue<TreeNode> = LinkedList()
        queue.add(root)

        val sb = StringBuilder()

        sb.append("#," + root.value)

        while (!queue.isEmpty()) {
            val node = queue.poll()

            if (node.left != null) {
                queue.add(node.left)
                sb.append("," + node.left!!.value)
            } else {
                sb.append(",#")
            }

            if (node.right != null) {
                queue.add(node.right)
                sb.append("," + node.right!!.value)
            } else {
                sb.append(",#")
            }
        }
        return sb.toString()
    }
}