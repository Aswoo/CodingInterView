fun hammingDistance(x: Int, y: Int): Int {
    var xor = x xor y

    return Integer.bitCount(xor)
}