fun numJewelsInStones(j: String, s: String): Int {
    var count = 0
    val freqs: MutableSet<Char> = HashSet()

    for (jewel in j.toCharArray()) {
        freqs.add(jewel)
    }
    for (stone in s.toCharArray()) {
        if (freqs.contains(stone)) count++
    }
    return count
}
