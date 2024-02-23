fun validUtf8(data: IntArray): Boolean {
    var start = 0

    fun check(size: Int): Boolean {
        // size 만큼 이동하면서 각 바이트 10으로 시작 여부 확인

        for (i in start + 1 until start + size + 1) {
            if (i >= data.size || data[i] shr 6 != 2) {
                return false
            }
        }
        return true
    }

    while (start < data.size) {
        val first = data[start]
        when {
            // 11110으로 시작하면 나머지가 3바이트이여야 한다.
            first shr 3 == 30 && check(3) -> start += 4
            // 1110 으로 시작하면 나머지가 2바이트 이여야한다.
            first shr 4 == 14 && check(2) -> start += 3
            // 110 으로 시작하면 나머지가 1바이트 여야한다.
            first shr 5 == 6 && check(1) -> start += 2
            // 1바이트 문자
            first shr 7 == 0 -> start++
            else -> return false
        }
    }
    return true
}