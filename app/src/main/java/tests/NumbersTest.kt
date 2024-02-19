package tests

import org.junit.Test
import org.junit.Assert.assertEquals

class NumbersTest{

    @Test
    fun test(){
        val numbers: Numbers = Numbers.Base(12,4)
        val expected: Int = 16
        val actual = numbers.sum()
        assertEquals(expected, actual)
    }
    @Test
    fun test_diff(){
        val numbers: Numbers = Numbers.Base(12,4)
        val expected: Int = 8
        val actual = numbers.dif()
        assertEquals(expected,actual)
    }
    @Test
    fun test_divided(){
        val numbers: Numbers = Numbers.Base(12,4)
        val expected: Int = 3
        val actual = numbers.div()
        assertEquals(expected,actual)
    }
}