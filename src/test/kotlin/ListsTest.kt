import Lists.indicesOf
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.contains
import org.hamcrest.Matchers.empty
import org.junit.jupiter.api.Test

class ListsTest {

    @Test
    fun testIndicesOf() {
        assertThat(listOf(1, 2, 3, 4).indicesOf(2), contains(1))
        assertThat(listOf(1, 2, 3, 4).indicesOf { it % 2 == 0 }, contains(1, 3))
        assertThat(listOf(1, 2, 3, 4).indicesOf { it > 4 }, empty())
        assertThat("Hello, world!".toList().indicesOf('l'), contains(2, 3, 10))
        assertThat("Hello, world!".toList().indicesOf('z'), empty())
    }
}
