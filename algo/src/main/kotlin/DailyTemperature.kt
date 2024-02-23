import java.util.ArrayDeque
import java.util.Deque

fun dailyTemperature(nums: IntArray): IntArray {

    val temperDeque: Deque<Int> = ArrayDeque<Int>()
    val result = IntArray(nums.size)
    for (i in nums.indices) {
        while (!temperDeque.isEmpty() && nums[i] > nums[temperDeque.peek()]) {
            val last = temperDeque.pop()
            result[last] = i - last
        }
        temperDeque.push(i)
    }
    return result
}

fun main() {
    val s = intArrayOf(23, 24, 25, 21, 19, 22, 26, 23)
    val array = dailyTemperature(s)
    println()
}