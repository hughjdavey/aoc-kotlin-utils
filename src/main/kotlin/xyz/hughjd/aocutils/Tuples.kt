package xyz.hughjd.aocutils

object Tuples {

    /**
     * Returns a pair containing the results of applying the given transform function to both elements in the original pair
     */
    fun <T, R> Pair<T, T>.map(mapper: (t: T) -> R): Pair<R, R> {
        return mapper(this.first) to mapper(this.second)
    }

    /**
     * Returns the sum of the elements of the pair
     */
    fun Pair<Int, Int>.sum(): Int = this.first + this.second

    /**
     * Returns the product of the elements of the pair
     */
    fun Pair<Int, Int>.product(): Int = this.first * this.second

    /**
     * Returns a triple containing the results of applying the given transform function to all three elements in the original triple
     */
    fun <T, R> Triple<T, T, T>.map(mapper: (t: T) -> R): Triple<R, R, R> {
        return Triple(mapper(this.first), mapper(this.second), mapper(this.third))
    }

    /**
     * Returns the sum of the elements of the triple
     */
    fun Triple<Int, Int, Int>.sum() = this.first + this.second + this.third

    /**
     * Returns the product of the elements of the triple
     */
    fun Triple<Int, Int, Int>.product() = this.first * this.second * this.third
}
