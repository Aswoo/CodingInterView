fun trappingRainWater(height: IntArray): Int {

    var volume = 0
    var left = 0
    var right = height.size

    var leftMax = height[left]
    var rightMax = height[right]

    // two pointer
    while(left < right) {
        leftMax = height[left].coerceAtLeast(leftMax)
        rightMax = height[right].coerceAtLeast(rightMax)

        //더 높은 쪽을 향해 투 포인터 이동
        if(leftMax <= rightMax) {
            volume += leftMax - height[left]
            left += 1
        } else {
            volume += rightMax - height[right]
            right -= 1
        }
    }
    return volume
}