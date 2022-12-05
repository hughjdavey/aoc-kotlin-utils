package xyz.hughjd.aocutils

import java.util.Stack

object Collections {

    /**
     * Returns all indices where the specified element occurs in the list, or an empty list if the specified element is not contained in the list
     */
    fun <T> List<T>.indicesOf(predicate: (t: T) -> Boolean): List<Int> {
        return this.mapIndexedNotNull { index, t2 -> if (predicate(t2)) index else null }
    }

    /**
     * Returns indices of all elements matching the given predicate, or an empty list if there are no such matches
     */
    fun <T> List<T>.indicesOf(t: T): List<Int> {
        return this.indicesOf { t2 -> t2 == t }
    }

    /**
     * Splits this list to a list of lists around matches of the given predicate. Analogous to String.split
     *
     * @see String.split
     */
    fun <T> List<T>.split(predicate: (t: T) -> Boolean): List<List<T>> {
        if (this.isEmpty()) {
            return emptyList()
        }

        val indices = this.indicesOf(predicate)
        if (indices.isEmpty()) {
            return listOf(this)
        }

        return this.foldIndexed<T, List<List<T>>>(listOf()) { index, acc, elem ->
            if (indices.contains(index)) acc.plusElement(listOf()) else {
                val ts = if (acc.isEmpty()) listOf() else acc.last()
                acc.dropLast(1).plusElement(ts + elem)
            }
        }.dropLastWhile { it.isEmpty() }
    }

    /**
     * Splits this list to a list of lists around matches of the given element. Analogous to String.split
     *
     * @see String.split
     */
    fun <T> List<T>.split(t: T): List<List<T>> {
        return this.split { t2 -> t2 == t }
    }


    /**
     * Returns a stack containing the elements of the input list, the first element being at the top of the stack
     */
    fun <T> stackOf(input: List<T>): Stack<T> {
        val stack = Stack<T>()
        input.reversed().forEach { stack.push(it) }
        return stack
    }

    /**
     * Returns a stack containing the input elements, the first element being at the top of the stack
     */
    fun <T> stackOf(vararg input: T): Stack<T> {
        return stackOf(input.toList())
    }
}
