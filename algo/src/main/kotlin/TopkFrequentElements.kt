import java.util.PriorityQueue

fun topKFrequentElements(nums: IntArray, k: Int): IntArray {

    val map: MutableMap<Int, Int> = mutableMapOf()

    for (n in nums) {
        map[n] = map.getOrDefault(n, 0) + 1
    }

    val pq: PriorityQueue<IntArray> = PriorityQueue { a: IntArray, b: IntArray ->
        b[1] - a[1]
    }

    for(elem in map.keys) {
        pq.add(intArrayOf(elem,map[elem]!!))
    }
    val result = IntArray(k)
    for(i in 0 until k) {
        result[i] = pq.poll()[0]
    }
    return result
}