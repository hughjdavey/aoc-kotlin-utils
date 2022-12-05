package xyz.hughjd.aocutils

import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher
import java.util.Stack

object CustomMatchers {

    class StackMatcher<T>(private vararg val expectedChars: T) : TypeSafeMatcher<Stack<T>>() {

        // useful for reporting in describeMismatchSafely since pop() mutates the stack
        private val popsSoFar = mutableListOf<T>()

        override fun matchesSafely(stack: Stack<T>?): Boolean {
            if (stack == null) {
                return false
            }
            for (i in 0 until stack.size) {
                val pop = stack.pop()
                popsSoFar.add(pop)
                if (pop != expectedChars[i]) {
                    return false
                }
            }
            return true
        }

        override fun describeTo(description: Description?) {
            description?.appendText("stack that pops " + expectedChars.toList())
        }

        override fun describeMismatchSafely(item: Stack<T>?, mismatchDescription: Description?) {
            mismatchDescription?.appendText("was stack that has popped $popsSoFar")
        }

        companion object {

            fun <T> popsElements(vararg expectedChars: T): Matcher<Stack<T>> {
                return StackMatcher(*expectedChars)
            }
        }
    }
}
