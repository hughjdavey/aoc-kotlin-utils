package xyz.hughjd.aocutils

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.contains
import org.hamcrest.Matchers.empty
import org.junit.jupiter.api.Test
import xyz.hughjd.aocutils.Collections.indicesOf
import xyz.hughjd.aocutils.Collections.split
import xyz.hughjd.aocutils.Collections.stackOf
import xyz.hughjd.aocutils.Collections.takeWhileInclusive
import xyz.hughjd.aocutils.CustomMatchers.StackMatcher.Companion.popsElements

class CollectionsTest {

    @Test
    fun testIndicesOf() {
        assertThat(listOf(1, 2, 3, 4).indicesOf(2), contains(1))
        assertThat(listOf(1, 2, 3, 4).indicesOf { it % 2 == 0 }, contains(1, 3))
        assertThat(listOf(1, 2, 3, 4).indicesOf { it > 4 }, empty())
        assertThat("Hello, world!".toList().indicesOf('l'), contains(2, 3, 10))
        assertThat("Hello, world!".toList().indicesOf('z'), empty())
    }

    @Test
    fun testSplit() {
        assertThat(listOf("part", "one", "", "part", "two").split(""), contains(listOf("part", "one"), listOf("part", "two")))
        assertThat(listOf("part", "one", "", "part", "two", "", "part", "three").split(""), contains(listOf("part", "one"), listOf("part", "two"), listOf("part", "three")))
        assertThat(listOf(1, 2, 3, 0, 4, 5, 6).split(0), contains(listOf(1, 2, 3), listOf(4, 5, 6)))
        assertThat(listOf<Int>().split(1), empty())
        assertThat(listOf(1, 2, 3, 4, 5, 6).split { i -> i % 2 == 0 }, contains(listOf(1), listOf(3), listOf(5)))
        assertThat(listOf(1, 2, 3, 4, 5, 6).split { i -> i % 2 == 1 }, contains(listOf(2), listOf(4), listOf(6)))
        assertThat(listOf("part", "one", "", "part", "two", null, "part", "three").split { s -> s.isNullOrEmpty() }, contains(listOf("part", "one"), listOf("part", "two"), listOf("part", "three")))
    }

    @Test
    fun testStackOf() {
        assertThat(stackOf<Int>(), empty())
        assertThat(stackOf(1, 2, 3), popsElements(1, 2, 3))
        assertThat(stackOf(listOf(1, 2, 3)), popsElements(1, 2, 3))
    }

    @Test
    fun testTakeWhileInclusive() {
        assertThat(listOf(1, 2, 3, 4, 5).takeWhile { it < 4 }, contains(1, 2, 3))
        assertThat(listOf(1, 2, 3, 4, 5).takeWhileInclusive { it < 4 }, contains(1, 2, 3, 4))
        assertThat(listOf(1, 2, 3, 4, 4, 4, 5).takeWhileInclusive { it < 4 }, contains(1, 2, 3, 4))
        assertThat(generateSequence(1) { it + 1 }.takeWhile { it < 4 }.toList(), contains(1, 2, 3))
        assertThat(generateSequence(1) { it + 1 }.takeWhileInclusive { it < 4 }.toList(), contains(1, 2, 3, 4))
        assertThat(generateSequence(1) { it + 1 }.takeWhileInclusive { it < 4 }.toList(), contains(1, 2, 3, 4))
    }
}
