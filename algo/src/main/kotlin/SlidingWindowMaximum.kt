import java.util.ArrayDeque
import java.util.Deque

fun slidingWindowMaximum(nums: IntArray, k: Int): IntArray {
    var result: MutableList<Int> = mutableListOf()
    val dq: Deque<Int> = ArrayDeque()

    for (i in nums) {
        if (!dq.isEmpty() && dq.peek() < i - k + 1) dq.poll()

        while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
            dq.pollLast()
        }
        dq.add(i)

        if (i >= k - 1) result.add(nums[dq.peek()])
    }
    return result.toIntArray()


}
