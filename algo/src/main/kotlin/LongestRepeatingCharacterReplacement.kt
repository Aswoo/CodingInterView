fun longestRepeatingCharacterReplacement(s: String, k: Int) {


    val map: MutableMap<Char, Int> = mutableMapOf()

    var maxLen = Int.MIN_VALUE
    var left = 0
    var right = 0

    for (c in s.toCharArray()) {
        map[c] = map.getOrDefault(c, 0) + 1
    }

    for (c in s.toCharArray()) {
        right++
        if (s.contains(s[right])) {

        }
    }
}