import java.util.ArrayDeque
import java.util.Deque

fun subSets(nums: IntArray): MutableList<List<Int>> {

    val results : MutableList<List<Int>> = mutableListOf()

    fun dfs(index: Int, path: Deque<Int>) {

        results.add(ArrayList(path))
        for (i in index until nums.size) {
            path.add(nums[i])
            dfs(index +1,path)
            path.removeLast()
        }
    }
    dfs(0,ArrayDeque())
    return results
}