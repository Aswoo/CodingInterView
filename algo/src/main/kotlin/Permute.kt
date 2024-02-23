import java.util.*
import java.util.stream.Collectors
import kotlin.collections.ArrayList

fun permute(nums: IntArray): List<List<Int>> {
    val result: MutableList<List<Int>> = mutableListOf()

    fun dfs(prevElements: MutableList<Int>, elements: List<Int>) {
        if (elements.isEmpty()) {
            result.add(prevElements.stream().collect(Collectors.toList()))
        }

        for (e in elements) {
            val nextElements : MutableList<Int> = ArrayList(elements)
            nextElements.remove(e)

            prevElements.add(e)
            dfs(prevElements,nextElements)
            //돌아온 이후 prevElement에서 현재 엘리먼트 삭제
            prevElements.remove(e)
        }
    }

    val lst = Arrays.stream(nums).boxed().collect(Collectors.toList())
    dfs(mutableListOf(),lst)
    return result
}