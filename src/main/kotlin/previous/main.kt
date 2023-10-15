package previous

fun main(args: Array<String>) {
    //first task
    println(countComission(100))
    println(countComission(30000))

    //second task
    for (i in 0..25) {
        printLikes(i)
    }

    //third task
    println(meloman(1000, true))
    println(meloman(1000, false))
    println(meloman(10000, true))
    println(meloman(10000, false))
    println(meloman(100000, false))
}

fun countComission(amount: Int): Int {
    val comissionPercent = 0.75
    val minComissionValue = 35

    val percent = Math.round(amount * comissionPercent / 100).toInt()
    val result = if(percent < minComissionValue) {
        minComissionValue
    } else {
        percent
    }
    return result
}

fun printLikes(likes: Int) {
    val result = if(likes % 10 == 1 && likes != 11){
        "Понравилось $likes человеку"
    } else {
        "Понравилось $likes людям"
    }
    println(result)
}

fun meloman(purchaseSum: Int, isConstantByer: Boolean): Int {
    val baseDiscount = 100
    val premiumDiscountPercentage = 0.05
    val constantBuyerDiscountPercentage = 0.01

    var result: Int = if(purchaseSum <= 1000) {
        purchaseSum
    } else if(purchaseSum in 1001..10_000) {
        purchaseSum - baseDiscount
    } else {
        (purchaseSum - (purchaseSum * premiumDiscountPercentage)).toInt()
    }

    if(isConstantByer) {
        result = (result - (purchaseSum * constantBuyerDiscountPercentage)).toInt()
    }
    return result
}