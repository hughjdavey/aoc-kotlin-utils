package xyz.hughjd.aocutils

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.jupiter.api.Test
import xyz.hughjd.aocutils.Tuples.map
import xyz.hughjd.aocutils.Tuples.product
import xyz.hughjd.aocutils.Tuples.sum

class TuplesTest {

    @Test
    fun testMap() {
        assertThat((2 to 2).map { it * 2 }, `is`(4 to 4))
        assertThat(("2" to "2").map(String::toInt), `is`(2 to 2))
        assertThat((true to false).map { it xor true }, `is`(false to true))
        assertThat(Triple(2, 4, 6).map { it / 2 }, `is`(Triple(1, 2, 3)))
        assertThat(Triple("fish", "and", "chips").map(String::uppercase), `is`(Triple("FISH", "AND", "CHIPS")))
    }

    @Test
    fun testSum() {
        assertThat((2 to 2).sum(), `is`(4))
        assertThat((5 to 5).sum(), `is`(10))
        assertThat(Triple(1, 2, 3).sum(), `is`(6))
        assertThat(Triple(5, 5, 5).sum(), `is`(15))
    }

    @Test
    fun testProduct() {
        assertThat((2 to 2).product(), `is`(4))
        assertThat((5 to 5).product(), `is`(25))
        assertThat(Triple(1, 2, 3).product(), `is`(6))
        assertThat(Triple(5, 5, 5).product(), `is`(125))
    }
}
