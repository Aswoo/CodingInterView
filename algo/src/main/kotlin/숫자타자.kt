fun solution(numbers: String): Int {
    var result = Int.MAX_VALUE
    val cost = arrayOf(
        intArrayOf(1, 7, 6, 7, 5, 4, 5, 3, 2, 3),
        intArrayOf(7, 1, 2, 4, 2, 3, 5, 4, 5, 6),
        intArrayOf(6, 2, 1, 2, 3, 2, 3, 5, 4, 5),
        intArrayOf(7, 4, 2, 1, 5, 3, 2, 6, 5, 4),
        intArrayOf(5, 2, 3, 5, 1, 2, 4, 2, 3, 5),
        intArrayOf(4, 3, 2, 3, 2, 1, 2, 3, 2, 3),
        intArrayOf(5, 5, 3, 2, 4, 2, 1, 5, 3, 2),
        intArrayOf(3, 4, 5, 6, 2, 3, 5, 1, 2, 4),
        intArrayOf(2, 5, 4, 5, 3, 2, 3, 2, 1, 2),
        intArrayOf(3, 6, 5, 4, 5, 3, 2, 4, 2, 1)
    )

    lateinit var dp: Array<Array<IntArray>>
    lateinit var arr: String
    var len: Int = 0

    fun solve(cnt: Int, L: Int, R: Int): Int {
        if (cnt == len) return 0
        if (dp[cnt][L][R] != -1) return dp[cnt][L][R]
        val num = arr[cnt] - '0'
        var result = Int.MAX_VALUE
        if (num != R) result = Math.min(solve(cnt + 1, num, R) + cost[L][num], result)
        if (num != L) result = Math.min(solve(cnt + 1, L, num) + cost[R][num], result)
        dp[cnt][L][R] = result
        return result
    }

    arr = numbers
    len = numbers.length
    var answer: Int = 0
    dp = Array(len + 1) { Array(10) { IntArray(10) { -1 } } }
    return solve(0, 4, 6)
}

fun main() {
    val numbers = "5123"
    println(solution(numbers))
}

