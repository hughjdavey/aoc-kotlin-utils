package xyz.hughjd.aocutils

object Pairs {

    /**
     * Returns a pair containing the results of applying the given transform function to both elements in the original pair
     */
    fun <T, R> Pair<T, T>.map(mapper: (t: T) -> R): Pair<R, R> {
        listOf<Int>().map {  }
        return mapper(this.first) to mapper(this.second)
    }
}
