package xyz.hughjd.aocutils

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.contains
import org.hamcrest.Matchers.empty
import org.junit.jupiter.api.Test
import xyz.hughjd.aocutils.Strings.indicesOf

class StringsTest {

    @Test
    fun testIndicesOf() {
        assertThat("abracadabra".indicesOf('a'), contains(0, 3, 5, 7, 10))
        assertThat("abracadabra".indicesOf('b'), contains(1, 8))
        assertThat("abracadabra".indicesOf('e'), empty())
        assertThat("abracadabra".indicesOf { it == 'a' || it == 'b' }, contains(0, 1, 3, 5, 7, 8, 10))
        assertThat("abracadabra".indicesOf { it == 'y' || it == 'z' }, empty())
    }
}
