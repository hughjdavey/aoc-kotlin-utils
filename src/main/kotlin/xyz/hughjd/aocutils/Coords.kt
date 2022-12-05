package xyz.hughjd.aocutils

import kotlin.math.abs

object Coords {

    data class Coord(val x: Int, val y: Int) {

        /**
         * Returns a Coord representing the difference in position between this Coord and another
         *
         * If called with no arguments, returns diff from the origin (0, 0)
         */
        fun diff(from: Coord = Coord(0, 0)): Coord {
            return Coord(x - from.x, y - from.y)
        }

        /**
         * Returns the [Manhattan Distance](https://en.wikipedia.org/wiki/Taxicab_geometry) from another Coord
         *
         * If called with no arguments, returns distance from the origin (0, 0)
         */
        fun manhattan(from: Coord = Coord(0, 0)): Int {
            return diff(from).absSum()
        }

        /**
         * Returns the 4 (or 8 if diagonals are included) adjacent coordinates on an infinite 2D grid
         *
         * @param includeDiagonals whether to include diagonally-adjacent coordinates
         */
        fun getAdjacent(includeDiagonals: Boolean): List<Coord> {
            return (-1..1).flatMap { dy -> (-1..1).map { dx -> copy(x = x + dx, y = y + dy) } }
                .filterNot { it == this }
                .filter { includeDiagonals || it.x == this.x || it.y == this.y }
        }

        /**
         * Returns a new Coord with the given amount added to the x coordinate
         */
        fun plusX(delta: Int) = copy(x = x + delta)

        /**
         * Returns a new Coord with the given amount subtracted from the x coordinate
         */
        fun minusX(delta: Int) = copy(x = x - delta)

        /**
         * Returns a new Coord with the given amount added to the y coordinate
         */
        fun plusY(delta: Int) = copy(y = y + delta)

        /**
         * Returns a new Coord with the given amount subtracted from the y coordinate
         */
        fun minusY(delta: Int) = copy(y = y - delta)

        private fun absSum() = abs(x) + abs(y)
    }
}
