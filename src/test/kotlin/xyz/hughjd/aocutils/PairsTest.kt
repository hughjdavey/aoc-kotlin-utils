package xyz.hughjd.aocutils

import xyz.hughjd.aocutils.Pairs.map
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.jupiter.api.Test

class PairsTest {

    @Test
    fun testMap() {
        assertThat((2 to 2).map { it * 2 }, `is`(4 to 4))
        assertThat(("2" to "2").map(String::toInt), `is`(2 to 2))
        assertThat((true to false).map { it xor true }, `is`(false to true))
    }
}
