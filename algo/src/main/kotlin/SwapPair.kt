import utils.ListNode

fun swapPair(head: ListNode?): ListNode? {
    if (head?.next != null) {
        // 다음 노드 선언
        val p = head.next!!
        head.next = swapPair(head.next!!.next)
        // 다음 다음 노드를 현재 노드로 지정
        p.next = head
        return p
    }
    return head
}