fun main(args: Array<String>) {
    //first task
    println(agoToText(60))
    println(agoToText(120))
    println(agoToText(86401))

    //second task
    println(countComission(100_000))
    println(countComission(100_000, "Visa"))
    println(countComission(100_000, "Maestro", 30000))
    println(countComission(100_000, "Maestro", 75_000))
    println(countComission(75_000, "Maestro", 0))
}

// First task
fun agoToText(seconds: Int): String  = when(seconds) {
    in 0 ..60 -> "был(а) только что"
    in 61 .. 60 * 60  -> countMinutes(seconds)
    in 60 * 60 + 1 .. 24 * 60 * 60 -> countHours(seconds)
    in 24 * 60 * 60 + 1 .. 48 * 60 * 60 -> "был(а) вчера"
    in 48 * 60 * 60 + 1 .. 72 * 60 * 60 -> "был(а) позавчера"
    else -> "был(а) давно"
}

fun countMinutes(seconds: Int): String {
    val minutes = seconds / 60
    return when {
        (minutes % 10 == 1) && (minutes % 100 != 11) -> "был(а) $minutes минуту назад"
        (minutes % 10 == 2) && (minutes % 100 != 12) -> "был(а) $minutes минуты назад"
        (minutes % 10 == 3) && (minutes % 100 != 13) -> "был(а) $minutes минуты назад"
        (minutes % 10 == 4) && (minutes % 100 != 14) -> "был(а) $minutes минуты назад"
        else -> "был(а) $minutes минут назад"
    }
}

fun countHours(seconds: Int): String {
    val hours = seconds / 3600
    return when {
        (hours % 10 == 1) && (hours % 100 != 11) -> "был(а) $hours час назад"
        (hours % 10 == 2) && (hours % 100 != 12) -> "был(а) $hours часа назад"
        (hours % 10 == 3) && (hours % 100 != 13) -> "был(а) $hours часа назад"
        (hours % 10 == 4) && (hours % 100 != 14) -> "был(а) $hours часа назад"
        else -> "был(а) $hours часов назад"
    }
}

// Second task

fun countComission(amount: Int, cardType: String = "VK Pay", previousSum: Int = 0): Int = when(cardType) {
    "VK Pay" -> 0
    "Visa" -> countVisaAndMirComission(amount)
    "Мир" -> countVisaAndMirComission(amount)
    else -> countMaestroAndMasterCardComission(amount, previousSum)
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
