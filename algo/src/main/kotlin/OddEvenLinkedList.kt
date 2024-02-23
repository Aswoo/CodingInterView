import utils.ListNode

// T:O(n) S:O(1)
fun oddEvenList(head: ListNode?): ListNode? {
    val odd = ListNode(-1)
    var p: ListNode? = odd
    val even = ListNode(-1)
    var q: ListNode? = even
    val dummy = ListNode(-1)
    dummy.next = head

    var isOdd = true
    while (dummy.next != null) {
        val cur = dummy.next
        if (isOdd) {
            p?.next = cur
            dummy.next = cur?.next
            cur?.next = null
            p = p?.next
        } else {
            q?.next = cur
            dummy.next = cur?.next
            cur?.next = null
            q = q?.next
        }
        isOdd = !isOdd
    }
    p?.next = even.next
    return odd.next
}