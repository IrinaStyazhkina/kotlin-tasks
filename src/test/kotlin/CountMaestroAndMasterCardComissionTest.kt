import org.junit.Test

import org.junit.Assert.*

class CountMaestroAndMasterCardComissionTest {
    @Test
    fun countComissionWithDefaultPreviousSum() {
        val amount = 75_000
        val result = countMaestroAndMasterCardComission(amount)
        assertEquals("Comission count with default values",0, result)
    }

    @Test
    fun countComissionWhenAmountLessThanMonthLimit() {
        val amount = 15_000
        val previousAmount = 60_000
        val result = countMaestroAndMasterCardComission(amount, previousAmount)
        assertEquals("Comission has to be not charged",0, result)
    }

    @Test
    fun countComissionWhenAmountOverMonthLimit() {
        val amount = 15_000
        val previousAmount = 75_000
        val result = countMaestroAndMasterCardComission(amount, previousAmount)
        assertEquals("Comission has to be charged",110, result)
    }

    @Test
    fun countComissionWhenAmountPartlyMoreThanMonthLimit() {
        val amount = 15_000
        val previousAmount = 65_000
        val result = countMaestroAndMasterCardComission(amount, previousAmount)
        assertEquals("Comission has to be change for the sum exceeding limit",50, result)
    }



}