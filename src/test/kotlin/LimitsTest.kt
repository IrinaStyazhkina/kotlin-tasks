import org.junit.Test

import org.junit.Assert.*

class LimitsTest {
    val VK_PAY_CARD_TYPE = "VK Pay"
    val MIR_PAY_CARD_TYPE = "Мир"

    @Test
    fun checkOnceLimitNotExceededForVkPay() {
        val amount = 15_000
        val previousSum = 0
        val result = isLimitNotExceeded(amount, VK_PAY_CARD_TYPE, previousSum)
        assertEquals(true, result)
    }

    @Test
    fun checkOnceLimitExceededForVkPay() {
        val amount = 15_001
        val previousSum = 0
        val result = isLimitNotExceeded(amount, VK_PAY_CARD_TYPE, previousSum)
        assertEquals(false, result)
    }

    @Test
    fun checkMonthLimitNotExceededForVkPay() {
        val amount = 15_000
        val previousSum = 25_000
        val result = isLimitNotExceeded(amount, VK_PAY_CARD_TYPE, previousSum)
        assertEquals(true, result)
    }

    @Test
    fun checkMonthLimitExceededForVkPay() {
        val amount = 15_001
        val previousSum = 25_000
        val result = isLimitNotExceeded(amount, VK_PAY_CARD_TYPE, previousSum)
        assertEquals(false, result)
    }

    @Test
    fun checkOnceLimitNotExceededForOtherPay() {
        val amount = 150_000
        val previousSum = 0
        val result = isLimitNotExceeded(amount, MIR_PAY_CARD_TYPE, previousSum)
        assertEquals(true, result)
    }

    @Test
    fun checkOnceLimitExceededForOtherPay() {
        val amount = 150_001
        val previousSum = 0
        val result = isLimitNotExceeded(amount, MIR_PAY_CARD_TYPE, previousSum)
        assertEquals(false, result)
    }

    @Test
    fun checkMonthLimitNotExceededForOtherPay() {
        val amount = 150_000
        val previousSum = 450_000
        val result = isLimitNotExceeded(amount, MIR_PAY_CARD_TYPE, previousSum)
        assertEquals(true, result)
    }

    @Test
    fun checkMonthLimitExceededForOtherPay() {
        val amount = 150_001
        val previousSum = 450_000
        val result = isLimitNotExceeded(amount, MIR_PAY_CARD_TYPE, previousSum)
        assertEquals(false, result)
    }

    @Test
    fun checkLimitsNotExceedingWithDefaultValues() {
        val amount = 15_000
        val result = isLimitNotExceeded(amount)
        assertEquals(true, result)
    }

    @Test
    fun checkLimitsExceedingWithDefaultValues() {
        val amount = 15_001
        val result = isLimitNotExceeded(amount)
        assertEquals(false, result)
    }
}