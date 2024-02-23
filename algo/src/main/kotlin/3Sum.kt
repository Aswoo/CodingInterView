import java.util.*

fun threeSum(nums: IntArray) {
    var left: Int
    var right: Int
    var sum: Int
    val results: MutableList<List<Int>> = mutableListOf()
    Arrays.sort(nums)

    for (i in 0..<nums.size - 2) {
        //중복된 값 건너 뛰기
        if (i > 0 && nums[i] == nums[i - 1]) continue

        //간격을 좁혀가며 sum 계산
        left = i + 1
        right = nums.size - 1
        while (left < right) {
            sum = nums[i] + nums[left] + nums[right]
            if (sum < 0) left += 1
            else if (sum > 0) right -= 1
            else {
                results.add(listOf(nums[i], nums[left], nums[right]))

                while (left < right && nums[left] == nums[left + 1]) left += 1
                while (left < right && nums[right] == nums[right + 1]) right -= 1

                left += 1
                right -= 1
            }
        }
    }
}