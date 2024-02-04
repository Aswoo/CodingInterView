import org.jetbrains.annotations.TestOnly

fun isPalindrome(s: String): Boolean {
    // 정규식으로 유효한 문자만 추출 후 소문자로 변경
    val filteredString = s.replace("[^A-Za-z0-9]", "").lowercase()
    // 문자열을 뒤집은 다음 String으로 변경
    val reversedString = StringBuilder(filteredString).reverse().toString()
    // 동일 비교
    return filteredString == reversedString
}

fun isPalindromeFast(s: String): Boolean {
    var start = 0
    var end = s.length - 1
    // 서로 중앙으로 이동하다 겹치는 지점에서 종료
    while (start < end) {
        when {
            !Character.isLetterOrDigit(s[start]) -> start++
            !Character.isLetterOrDigit(s[end]) -> end--
            else -> {
                if (Character.toLowerCase(s[start]) != Character.toLowerCase(s[end])) {
                    return false
                }
                start++
                end--
            }
        }
    }
    return true
}

fun main() {
    val s = "gabccbag"
    // true
    println(isPalindrome(s))
    // false
    val s2 = "assfd"
    println(isPalindrome(s2))
}

