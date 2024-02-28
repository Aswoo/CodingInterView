import java.util.*
import kotlin.collections.ArrayList

fun sheepAndWolf(info: IntArray, edges: Array<IntArray>): Int {
    var answer = 1

    val graph: MutableMap<Int, MutableList<Int>> = mutableMapOf()
    for (edge in edges) {
        graph.putIfAbsent(edge[0], mutableListOf())
        graph[edge[0]]!!.add(edge[1])
    }
    val queue: Queue<SWNode> = LinkedList()
    queue.offer(SWNode(0, 1, 0, graph[0]!!))

    while (!queue.isEmpty()) {
        val node = queue.poll()

        for (nextNode in node.nodes) {
            val nextSheep = if (info[nextNode] == 0) node.sheep + 1 else node.sheep
            val nextWolves = if (info[nextNode] == 1) node.wolves + 1 else node.wolves

            if (nextSheep > nextWolves) {
                answer = answer.coerceAtLeast(nextSheep)

                val candidateNodes: MutableList<Int> = ArrayList(node.nodes)
                candidateNodes.remove(nextNode)

                if (graph[nextNode] != null) {
                    candidateNodes.addAll(graph[nextNode]!!)
                }

                queue.offer(SWNode(nextNode, nextSheep, nextWolves, candidateNodes))
            }
        }
    }
    return answer
}

class SWNode(val index: Int, val sheep: Int, val wolves: Int, val nodes: List<Int>)