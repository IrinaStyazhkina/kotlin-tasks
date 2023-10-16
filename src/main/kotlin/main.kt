fun main(args: Array<String>) {
    println(countComission(100_000))
}

fun countComission(amount: Int, cardType: String = "VK Pay", previousSum: Int = 0): Int {
    if(!isLimitNotExceeded(amount, cardType, previousSum)) {
        println("Вы превысили лимиты")
        return -1
    }
    return when (cardType) {
        "VK Pay" -> 0
        "Visa", "Мир" -> countVisaAndMirComission(amount)
        else -> countMaestroAndMasterCardComission(amount, previousSum)
    }
}

fun countVisaAndMirComission(amount: Int): Int {
    val comissionPercent = 0.75
    val minComissionValue = 35

    val percent = Math.round(amount * comissionPercent / 100).toInt()
    return if(percent < minComissionValue) {
        minComissionValue
    } else {
        percent
    }
}

fun countMaestroAndMasterCardComission(amount: Int, previousSum: Int = 0): Int {
    val limit = 75_000
    val comissionPercent = 0.6
    val fixedComission = 20

    val monthLimit = limit - previousSum

    return when {
        monthLimit <= 0 -> Math.round(amount * comissionPercent / 100).toInt() + fixedComission
        amount <= monthLimit -> 0
        else -> Math.round((amount - monthLimit) * comissionPercent / 100).toInt() + fixedComission
    }
}

fun isLimitNotExceeded(amount: Int, cardType: String = "VK Pay", previousSum: Int = 0): Boolean {
    val vkOnceLimit = 15000
    val vkMonthLimit = 40000

    val otherCardsOnceLimit = 150000
    val otherCardsMonthLimit = 600000

    if(cardType == "VK Pay") {
        return (amount <= vkOnceLimit) && (previousSum + amount <= vkMonthLimit)
    }

    return (amount <= otherCardsOnceLimit) && (previousSum + amount <= otherCardsMonthLimit)
}
