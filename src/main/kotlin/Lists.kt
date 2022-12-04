object Lists {

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
}
