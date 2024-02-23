fun numberOf1Bits(n: Int): Int {
    var n = n
    var count = 0

    while (n != 0) {
        n = n and n - 1
        count++
    }
    return count

}