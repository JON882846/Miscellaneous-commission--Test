package ru.netology

const val NAME_CARD_VK_PAY = "VK Pay"
const val NAME_CARD_VISA = "Visa"
const val NAME_CARD_MAESTRO = "Maestro"
const val NAME_CARD_MASTERCARD= "Mastercard"
const val NAME_CARD_MIR = "Mir"


fun main() {

    val сommissVK = commCalc(1000_00, prevTrans = 17_00)
    val сommissVKRub = messageRuble(сommissVK)
    val сommissVKPen = messagePenny(сommissVK)
    println("Коммисия за перевод по карте равна:\"VK Pay\" $сommissVKRub рублей $сommissVKPen копеек" )

    val сommissVisa = commCalc(105000_00, card = "Visa", prevTrans = 1007_00)
    val сommissVisaRub = messageRuble(сommissVisa)
    val сommissVisaPen = messagePenny(сommissVisa)
    println("Коммисия за перевод по карте равна:\"Visa\" $сommissVisaRub рублей $сommissVisaPen копеек" )

    val сommissMaestro = commCalc(1000_00, card = "Maestro", prevTrans = 17525_00)
    // message(c,"Maestro")
    val сommissMaestroRub = messageRuble(сommissMaestro)
    val сommissMaestroPen = messagePenny(сommissMaestro)
    println("Коммисия за перевод по карте равна:\"Maestro\" $сommissMaestroRub рублей $сommissMaestroPen копеек" )

    val сommissMir = commCalc(1000_00, card = "Mir", prevTrans = 1457_00)
    val сommissMirRub = messageRuble(сommissMir)
    val сommissMirPen = messagePenny(сommissMir)
    println("Коммисия за перевод по карте равна:\"Mir\" $сommissMirRub рублей $сommissMirPen копеек" )

    val сommissMaster = commCalc(100300_00, card = "Mastercard", prevTrans = 17000_00)
    val сommissMasterRub = messageRuble(сommissMaster)
    val сommissMasterPen = messagePenny(сommissMaster)
    println("Коммисия за перевод по карте равна:\"Mastercard\" $сommissMasterRub рублей $сommissMasterPen копеек" )
}

fun messageRuble(
    сommission: Int
): Int {
    val ruble = (сommission/100)
    return ruble
}


fun messagePenny(
    сommission: Int
): Int {
    val ruble = (сommission/100)
    val result = (сommission.toDouble()/100)
    val penny =  ((result - (ruble))*100).toInt()
    return penny
}

fun commCalc (
    amount: Int,
    card: String = "VK Pay",
    prevTrans: Int = 0
): Int{
    return when (card){
        NAME_CARD_VK_PAY-> {
            0
        }
        NAME_CARD_MAESTRO,NAME_CARD_MASTERCARD-> {
            val summTransMax = 75000_00
            val сommission = 0.6
            val сommissionFixed = 20_00

            val result = amount + prevTrans

            if (result > summTransMax) {
                return (((amount/100 * сommission)) + сommissionFixed).toInt()
            } else {
                0
            }
        }
        NAME_CARD_VISA,NAME_CARD_MIR->{
            val сommission = 0.75
            val fixedCommission = 3500
            val result = (((amount/100 * сommission))).toInt()
            return if(result>=fixedCommission){
                result
            }else{
                fixedCommission
            }
        }
        else -> {
            return 0
        }
    }
}

