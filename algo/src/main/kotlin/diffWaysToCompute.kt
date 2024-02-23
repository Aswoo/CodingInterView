import kotlin.math.exp

var memo: MutableMap<String, List<Int>> = mutableMapOf()

fun diffWaysToCompute(expression: String): List<Int> {
    val result: MutableList<Int> = mutableListOf()

    if (memo.containsKey(expression)) {
        return memo[expression]!!
    }

    for (i in expression.indices) {
        val c = expression[i]
        if (c in "+-*") {
            val left = diffWaysToCompute(expression.substring(0, i))
            val right = diffWaysToCompute(expression.substring(i + 1))

            for (l in left) {
                for (r in right) {
                    when (c) {
                        '+' -> result.add(l + r)
                        '-' -> result.add(l - r)
                        '*' -> result.add(l * r)
                    }
                }
            }
        }
    }
    if (result.isEmpty()) {
        result.add(expression.toInt())
    }
    memo[expression] = result
    return result
}