import java.util.*

fun enterTest(n: Int, times: IntArray): Long {
    var answer: Long = 0

    var left: Long = 1
    var right = Arrays.stream(times).max().asInt.toLong() * n
    var mid = right

    while (left <= right) {
        var calcN: Long = 0
        for (time in times) {
            calcN += mid / time
        }
        when {
            calcN >= n -> {
                answer = mid
                right = mid - 1
            }
            else -> {
                left = mid + 1
            }
        }
        mid = left + (right - left) / 2
    }
    return answer
}