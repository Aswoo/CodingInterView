import java.util.ArrayDeque
import java.util.ArrayList
import java.util.Deque

fun combinationSum(nums: IntArray, target: Int): MutableList<List<Int>> {

    val results: MutableList<List<Int>> = mutableListOf()

    fun dfs(target: Int, index: Int, path: Deque<Int>) {
        if (target < 0) return

        if (target == 0) {
            results.add(ArrayList(path))
            return
        }
        for (i in index until nums.size) {
            path.add(nums[i])
            dfs(target - nums[i], i, path)
            path.removeLast()
        }
    }

    dfs(target, 0,ArrayDeque())
    return results
}