package com.example.notes

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        checkingClosures(5, 4, { a: Int, b: Int -> a + b })
        checkingClosures(5, 4, fun(x: Int, y: Int): Int { return x + y })


    }

    private fun sum(a: Int, b: Int) = a + b

    private fun checkingClosures(a: Int, b: Int, f: (Int, Int) -> Int) = f(a, b)

}