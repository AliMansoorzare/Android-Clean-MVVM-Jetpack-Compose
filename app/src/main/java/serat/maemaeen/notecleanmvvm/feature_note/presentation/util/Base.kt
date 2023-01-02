package serat.maemaeen.notecleanmvvm.feature_note.presentation.util

import java.text.DecimalFormat

fun currencyFormat(amount: String): String {
    val formatter = DecimalFormat("###,###,###")
    return formatter.format(amount.toDouble())
}


fun setPersianNumbers(str: String): String {
    return str
        .replace("0", "۰")
        .replace("1", "۱")
        .replace("2", "۲")
        .replace("3", "۳")
        .replace("4", "۴")
        .replace("5", "۵")
        .replace("6", "۶")
        .replace("7", "۷")
        .replace("8", "۸")
        .replace("9", "۹")
}
