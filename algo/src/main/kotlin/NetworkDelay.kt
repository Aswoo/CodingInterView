import java.util.*
import kotlin.math.min

fun networkDelay(times: Array<Array<Int>>, n: Int, k: Int): Int {

    val graph: MutableMap<Int, MutableMap<Int, Int>> = mutableMapOf()
    for (time in times) {
        graph.putIfAbsent(time[0], mutableMapOf())
        graph[time[0]]!![time[1]] = time[2]
    }

    val pq: Queue<Map.Entry<Int, Int>> = PriorityQueue(compareBy { (node, time) -> time })
    pq.add(AbstractMap.SimpleEntry(k, 0))
    val dist: MutableMap<Int, Int> = mutableMapOf()

    while (!pq.isEmpty()) {
        val (u, dist_u) = pq.poll()
        // u까지의 소요시간이 아직 계산되지 않았다면 처리 시작
        if (!dist.containsKey(u)) {
            dist[u] = dist_u
            if (graph.containsKey(u)) {
                for ((v, length_u_v) in graph[u]!!) {
                    val alt = dist_u + length_u_v
                    pq.add(AbstractMap.SimpleEntry(v, alt))
                }
            }
        }
    }

    return if (dist.size == n) Collections.max(dist.values) else -1

}

fun main() {

    val times = arrayOf(
        arrayOf(3, 1, 5),
        arrayOf(3, 2, 2),
        arrayOf(2, 1, 2),
        arrayOf(3, 4, 1),
        arrayOf(4, 5, 1),
        arrayOf(5, 6, 1),
        arrayOf(6, 7, 1),
        arrayOf(7, 8, 1),
        arrayOf(8, 1, 1)
    )
    println(networkDelay(times, n = 8, k = 3))
}