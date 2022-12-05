package xyz.hughjd.aocutils

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.containsInAnyOrder
import org.hamcrest.Matchers.`is`
import org.junit.jupiter.api.Test
import xyz.hughjd.aocutils.Coords.Coord

class CoordsTest {

    @Test
    fun testDiff() {
        assertThat(Coord(4, 4).diff(), `is`(Coord(4, 4)))
        assertThat(Coord(-4, -4).diff(), `is`(Coord(-4, -4)))
        assertThat(Coord(-4, -4).diff(Coord(-2, 2)), `is`(Coord(-2, -6)))
    }

    @Test
    fun testManhattan() {
        assertThat(Coord(4, 4).manhattan(), `is`(8))
        assertThat(Coord(-4, -4).manhattan(), `is`(8))
        assertThat(Coord(-6, 2).manhattan(), `is`(8))
        assertThat(Coord(-6, 2).manhattan(Coord(16, -8)), `is`(32))
    }

    @Test
    fun testGetAdjacent() {
        assertThat(
            Coord(0, 0).getAdjacent(false), containsInAnyOrder(
            Coord(-1, 0), Coord(0, -1), Coord(1, 0), Coord(0, 1)
        ))
        assertThat(
            Coord(0, 0).getAdjacent(true), containsInAnyOrder(
            Coord(-1, 0), Coord(-1, -1), Coord(0, -1), Coord(1, -1),
            Coord(1, 0), Coord(1, 1), Coord(0, 1), Coord(-1, 1)
        ))
    }

    @Test
    fun testPlusAndMinus() {
        val coord = Coord(2, 4)
        assertThat(coord.plusX(2), `is`(Coord(4, 4)))
        assertThat(coord.plusY(3), `is`(Coord(2, 7)))
        assertThat(coord.minusX(6), `is`(Coord(-4, 4)))
        assertThat(coord.minusY(4), `is`(Coord(2, 0)))
    }
}
