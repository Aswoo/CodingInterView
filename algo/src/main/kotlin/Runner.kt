import utils.ListNode
import java.util.*

fun isPalindrome(head: ListNode?): Boolean {
    val deque: Deque<Int> = LinkedList()
    var node = head
    while (node != null) {
        deque.add(node.value)
        node = node.next
    }

    while (!deque.isEmpty() && deque.size > 1) {
        if (deque.pollFirst() !== deque.pollLast()) {
            return false
        }
    }
    return true
}