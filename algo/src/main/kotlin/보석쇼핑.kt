import kotlin.math.min

fun shopJewel(gems: Array<String>): IntArray {
    var left = 0
    var right = 0
    var minLen = Int.MAX_VALUE
    var minLeft = 0
    var minRight = 0
    var gemCount = gems.toSet().count()

    val countMap: MutableMap<String, Int> = mutableMapOf()

    for (gem in gems) {
        right++
        if (countMap.size < gemCount) {
            while (left < right) {
                countMap[gem] = countMap.getOrDefault(gem, 0) + 1
                left++
            }
        }
        if(countMap.size == gemCount) {

        }
    }

    return intArrayOf(minLeft, minRight)
}

fun solution(gems: Array<String>): IntArray {
    val set = gems.toSet()
    val map = mutableMapOf<String, Int>()

    var end = 0
    var shortest = Int.MAX_VALUE
    var shortestRange = Pair(0, 0)

    for(start in gems.indices){
        while(map.keys.size < set.size && end < gems.size){
            if(map[gems[end]] == null) map[gems[end]] = 0
            map[gems[end]] = map[gems[end]]!! + 1
            end++
        }
        if(map.keys.size == set.size){
            if(shortest > end - start){
                shortest = end - start
                shortestRange = Pair(start + 1, end)
            }
        }
        map[gems[start]] = map[gems[start]]!! - 1
        if(map[gems[start]] == 0) map.remove(gems[start])
    }

    return intArrayOf(shortestRange.first, shortestRange.second)
}
fun main() {
    val input = arrayOf("DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA")
    println(shopJewel(input).joinToString())
}