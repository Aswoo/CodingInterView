import utils.ListNode

fun mergeTwoList(list1 : ListNode?,list2 : ListNode?): ListNode? {
    if(list1 == null) return list2
    if(list2 == null) return list1

    return if (list1.value < list2.value) {
        list1.next = mergeTwoList(list1.next,list2)
        list1
    }else {
        list2.next = mergeTwoList(list1,list2.next)
        list2
    }
}