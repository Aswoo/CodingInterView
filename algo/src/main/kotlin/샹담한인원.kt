
import java.util.*
import kotlin.math.min

internal class Node(var start: Int, var time: Int)

fun solution(k : Int,n : Int,reqs : Array<IntArray>): Int {

    var answer = 0
    val list = ArrayList<ArrayList<Node>>()
    for (i in 0..n) {
        list.add(ArrayList())
    }
    for (i in reqs) {
        list[i[2]].add(Node(i[0], i[1]))
    }
    val sum_wait = Array(k + 1) { IntArray(n - k + 2) }

    for (i in 1..k) {
        for (j in 1..n - k + 1) {
            val que = PriorityQueue<Int>()
            for (nk in list[i]) {
                if (que.size < j) {
                    que.add(nk.start + nk.time)
                } else {
                    val min = que.poll()
                    val wait = min - nk.start
                    if (wait > 0) {
                        sum_wait[i][j] += wait
                        que.add(min + nk.time)
                    } else {
                        que.add(nk.start + nk.time)
                    }
                }
            }
        }
    }
    answer = dfs(n-k+1, sum_wait, 1, k);

    return answer
}
fun dfs(remain: Int, wait: Array<IntArray>, depth: Int, k: Int): Int {
    if (depth > k) return 0
    var sum = 100000000
    for (i in 1..remain) {
        sum = min((dfs(remain - i + 1, wait, depth + 1, k) + wait[depth][i]).toDouble(), sum.toDouble())
            .toInt()
    }
    return sum
}
