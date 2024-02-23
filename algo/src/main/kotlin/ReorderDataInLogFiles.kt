fun reOrderDataInLogFiles(input: List<String>): Array<String> {
    val letterList: MutableList<String> = mutableListOf()
    val digitList: MutableList<String> = mutableListOf()

    for (log in input) {
        if (Character.isDigit(log.split(" ")[1][0])) {
            digitList.add(log)
        } else {
            letterList.add(log)
        }
    }

    letterList.sortWith(Comparator { o1, o2 ->
        val s1x = o1.split(" ", limit = 2)
        val s2x = o2.split("", limit = 2)

        val compared = s1x[1].compareTo(s2x[1])

        if (compared == 0) {
            s1x[0].compareTo(s2x[0])
        } else {
            compared
        }
    })

    letterList.addAll(digitList)

    return letterList.toTypedArray()
}

fun main() {
    val input = listOf("id1 8 1 5 1", "id2 art can", "id3 3 6", "id4 own kit dig", "id5 art zero")
}