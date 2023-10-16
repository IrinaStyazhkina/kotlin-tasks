import org.junit.Test

import org.junit.Assert.*

class MainKtTest {
    val VK_PAY_CARD_TYPE = "VK Pay"
    val VISA_PAY_CARD_TYPE = "Visa"
    val MIR_PAY_CARD_TYPE = "Мир"
    val MAESTRO_PAY_CARD_TYPE = "Мaestro"

    @Test
    fun comissionNotCountedIfLimitsAreExceeded() {
        val amount = 5000
        val previousSum = 35001
        val result = countComission(amount, VK_PAY_CARD_TYPE, previousSum)
        assertEquals("Comission has to be not counted",-1, result)
    }

    @Test
    fun checkNoComissionForVkPay() {
        val amount = 15_000
        val previousSum = 0
        val result = countComission(amount, VK_PAY_CARD_TYPE, previousSum)
        assertEquals("VK Pay has no comission",0, result)
    }

    @Test
    fun countComissionForVisa() {
        val amount = 10_000
        val previousSum = 0
        val result = countComission(amount, VISA_PAY_CARD_TYPE, previousSum)
        assertEquals("Visa comission",75, result)
    }

    @Test
    fun countComissionForMir() {
        val amount = 10_000
        val previousSum = 0
        val result = countComission(amount, MIR_PAY_CARD_TYPE, previousSum)
        assertEquals("Mir comission",75, result)
    }

    @Test
    fun countComissionForMaestro() {
        val amount = 80_000
        val previousSum = 0
        val result = countComission(amount, MAESTRO_PAY_CARD_TYPE, previousSum)
        assertEquals("Maestro comission",50, result)
    }

    @Test
    fun countComissionWithDefaultValues() {
        val amount = 5000
        val result = countComission(amount)
        assertEquals("Comission with default values",0, result)
    }
}