fun twoSum(nums: IntArray, target: Int): IntArray {
    val numsMap: MutableMap<Int, Int> = mutableMapOf()

    for(i in nums) {
        if(numsMap.containsKey(target - nums[i])) {
            return intArrayOf(numsMap[target - nums[i]] ?: 0,i)
        }
        numsMap.put(nums[i],i)
    }
    return intArrayOf(0,0)
}