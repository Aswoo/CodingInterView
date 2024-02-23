fun minimumWindowSubString(s: String, t: String): String {

    val need: MutableMap<Char, Int> = mutableMapOf()

    for (c in t.toCharArray()) {
        need[c] = need.getOrDefault(c, 0) + 1
    }

    var missing = t.length
    var left = 0
    var right = 0
    var start = 0
    var end = 0
    var minLen = Int.MAX_VALUE


    for (c in s.toCharArray()) {
        right++
        if (need.containsKey(c) && need[c]!! > 0) {
            missing--
        }
        need[c] = need.getOrDefault(c, 0) - 1

        if (missing == 0) {
            // need 값이 0 이면 증가시키면서 왼쪽 포인터 이동
            while (left < right && need[s[left]]!! < 0) {
                need[s[left]] = need.getOrDefault(s[left], 0) + 1
                left++
            }
            if (minLen > right - left + 1) {
                minLen = right - left + 1
                start = left
                end = right
            }

            need[s[left]] = need.getOrDefault(s[left], 0) + 1
            missing++
            left++
        }

    }
    return s.substring(start, end)
}