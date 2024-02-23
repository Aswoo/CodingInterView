import kotlin.collections.*
import kotlin.math.*
import java.util.*
class Solution {
    fun solution(n: Int, paths: Array<IntArray>, gates: IntArray, summits: IntArray): IntArray {

        val gatesList = gates.toHashSet();
        val summitList = summits.toHashSet();

        // 위치, 거리
        val inputData = Array(n+1) { ArrayList<Pair<Int,Int>>() }
        for(path in paths){
            inputData[path[0]].add(Pair(path[1], path[2]))
            inputData[path[1]].add(Pair(path[0], path[2]))
        }
        // 다익스트라
        var answer = intArrayOf(-1, 30000000)

        for(gate in gatesList){
            val lengths = IntArray(n+1) { 30000000 }
            val checked = BooleanArray(n+1)

            // 도착지점, 길이
            val pq = PriorityQueue<Pair<Int,Int>>(compareBy({ it.second }, { it.first }))

            pq.add(Pair(gate,0));

            while(pq.isNotEmpty()){
                val now = pq.poll();

                if(checked[now.first] || now.second > answer[1]) {
                    continue
                }
                checked[now.first] = true
                lengths[now.first] = now.second

                if(now.first != gate && now.first in gatesList) continue
                if(now.first in summitList){
                    if(answer[1] > now.second){
                        answer[0] = now.first
                        answer[1] = now.second
                    }else if(answer[1] == now.second){
                        answer[0] = min(now.first, answer[0])
                    }
                    break
                }


                for(p in inputData[now.first]){
                    if(!checked[p.first]){
                        pq.add(Pair<Int,Int>(p.first, max(now.second, p.second)))
                    }
                }
            }

        }

        return answer
    }
    fun main2() {
        val n = 6
        val path =
            arrayOf(
                intArrayOf(1, 2, 3),
                intArrayOf(2, 3, 5),
                intArrayOf(2, 4, 2),
                intArrayOf(2, 5, 4),
                intArrayOf(3, 4, 5),
                intArrayOf(4, 5, 3),
                intArrayOf(5, 6, 1),
            )
        val gate = intArrayOf(1, 3)
        val summits = intArrayOf(5)

        val path2 =
            arrayOf(
                intArrayOf(1, 2, 5),
                intArrayOf(1, 4, 1),
                intArrayOf(2, 3, 1),
                intArrayOf(2, 6, 7),
                intArrayOf(4, 5, 1),
                intArrayOf(5, 6, 1),
                intArrayOf(6, 7, 1),
            )
        val gate2 = intArrayOf(3, 7)
        val summits2 = intArrayOf(1, 5)

        println(solution(7, path2, gate2, summits2).joinToString())
    }
}
