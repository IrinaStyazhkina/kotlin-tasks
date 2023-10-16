import org.junit.Test

import org.junit.Assert.*

class CountVisaAndMirComissionTest {
    @Test
    fun countComissionIfPercentLessThanMinValue() {
        val amount = 5000
        val result = countVisaAndMirComission(amount)
        assertEquals("Expect to get percent from sum",38, result)
    }

    @Test
    fun countComissionIfPercentMoreThanMinValue() {
        val amount = 4500
        val result = countVisaAndMirComission(amount)
        assertEquals("Expect to get min comission value", 35, result)
    }

}