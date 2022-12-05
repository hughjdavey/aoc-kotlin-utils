package xyz.hughjd.aocutils

import xyz.hughjd.aocutils.Collections.indicesOf

object Strings {

    /**
     * Returns indices of all elements characters matching the given predicate, or an empty list if there are no such matches
     */
    fun String.indicesOf(predicate: (c: Char) -> Boolean): List<Int> {
        return this.toList().indicesOf(predicate)
    }

    /**
     * Returns all indices within this string where the specified character occurs, or an empty list if the specified character does not occur
     */
    fun String.indicesOf(c: Char): List<Int> {
        return this.indicesOf { c2 -> c2 == c }
    }
}
