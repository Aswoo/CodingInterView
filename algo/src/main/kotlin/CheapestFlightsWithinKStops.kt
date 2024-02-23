import java.util.*
import java.util.AbstractMap.SimpleEntry

fun cheapestFlightsWithinKStops(n: Int, edges: Array<Array<Int>>, src: Int, dist: Int, k: Int): Int {


    val graph: MutableMap<Int, MutableMap<Int, Int>> = mutableMapOf()

    for (edge in edges) {
        graph[edge[0]]!![edge[1]] = edge[2]
    }


    // (도착지,비용,남은 경로)
    val pq: Queue<List<Int>> = PriorityQueue { a: List<Int>, b: List<Int> -> a[1] - b[1] }
    pq.add(listOf(src, 0, 0))

    val visited: MutableMap<Int, Int> = mutableMapOf()

    while (!pq.isEmpty()) {
        val cur = pq.poll()
        val u = cur[0]
        val price_u = cur[1]
        var k_visited = cur[2]

        if (u == dist) return price_u

        visited[u] = k_visited
        if (k_visited <= k) {
            k_visited += 1

            if (graph.containsKey(u)) {
                for ((key, value) in graph[u]!!) {
                    if (!visited.containsKey(key) || k_visited < visited[key]!!) {
                        val alt = price_u + value
                        pq.add(listOf(key,alt,k_visited))
                    }
                }
            }
        }
    }
    return -1
}