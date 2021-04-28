import org.junit.Test

import org.junit.Assert.*
import java.lang.Exception
import kotlin.test.assertFailsWith

class FizzBuzzTest {

    @Test
    fun Test_normal() {
        assertEquals("1", fizzBuzzWhizz(1))
        assertEquals("2", fizzBuzzWhizz(2))
    }

    @Test
    fun Test_3() {
        assertEquals("Fizz", fizzBuzzWhizz(3))
        assertEquals("Fizz", fizzBuzzWhizz(6))
    }

    @Test
    fun Test_5() {
        assertEquals("Buzz", fizzBuzzWhizz(5))
        assertEquals("Buzz", fizzBuzzWhizz(10))
    }

    @Test
    fun Test_7() {
        assertEquals("Whizz", fizzBuzzWhizz(7))
        assertEquals("Whizz", fizzBuzzWhizz(77))
    }

    @Test
    fun Test_15() {
        assertEquals("FizzBuzz", fizzBuzzWhizz(15))
        assertEquals("FizzBuzz", fizzBuzzWhizz(30))
    }

    @Test
    fun Test_When_5_appear_should_Buzz() {
        assertEquals("Buzz", fizzBuzzWhizz(25))
        assertEquals("Buzz", fizzBuzzWhizz(52))
    }

    @Test
    fun Test_When_7_appear_should_Whizz() {
        assertEquals("Whizz", fizzBuzzWhizz(7))
        assertEquals("Whizz", fizzBuzzWhizz(17))
    }

    @Test
    fun Test_When_3_appear_should_Fizz() {
        assertEquals("Fizz", fizzBuzzWhizz(31))
    }

    @Test
    fun Test_When_3_and_5_appear_should_FizzBuzz() {
        assertEquals("FizzBuzzWhizz", fizzBuzzWhizz(35))
        assertEquals("FizzBuzz", fizzBuzzWhizz(53))
    }

    @Test
    fun Test_When_3_and_7_appear_should_FizzWhizz() {
        assertEquals("FizzWhizz", fizzBuzzWhizz(37))
        assertEquals("FizzWhizz", fizzBuzzWhizz(73))
    }

    @Test
    fun Test_When_5_and_7_appear_should_BuzzWhizz() {
        assertEquals("FizzBuzzWhizz", fizzBuzzWhizz(57))
        assertEquals("FizzBuzzWhizz", fizzBuzzWhizz(75))
    }

    @Test
    fun Test_boundary() {
        assertFailsWith<Exception>("wtf ") { fizzBuzzWhizz(101) }
        assertFailsWith<Exception>("wtf ") { fizzBuzzWhizz(-1) }
    }

    private fun fizzBuzzWhizz(n: Int): String {
        if (n < 0 || n > 100) throw Exception()
        var result = ""
        if (isMatch(n, 3)) result += "Fizz"
        if (isMatch(n, 5)) result += "Buzz"
        if (isMatch(n, 7)) result += "Whizz"
        if (result.isEmpty()) result = n.toString()
        return result
    }

    private fun isMatch(source: Int, target: Int) = isMultiple(source, target)
                || source.toString().contains(target.toString())

    private fun isMultiple(n: Int, b: Int) = n % b == 0
}