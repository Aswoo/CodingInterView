import java.util.ArrayDeque
import java.util.Deque

class MyQueue {
    val input: Deque<Int> = ArrayDeque()
    val output: Deque<Int> = ArrayDeque()

    fun push(x: Int) {
        input.push(x)
    }

    fun pop(): Int {
        peek()
        return output.pop()
    }

    fun peek(): Int {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop())
            }
        }
        return output.peek()
    }

    fun empty(): Boolean {
        return input.isEmpty() && output.isEmpty()
    }
}