package com.springtask.utils

import java.util.*
import com.github.mfathi91.time.PersianDate
import java.time.ZoneId
import com.ibm.icu.util.ULocale
import com.ibm.icu.util.Calendar

fun Date.toPersianYearAndWeek(): Pair<Int, Int> {
    val locale = ULocale("fa_IR@calendar=persian")
    val calendar = Calendar.getInstance(locale)
    calendar.clear()
    calendar.time = this
    return calendar.get(Calendar.YEAR) to calendar.get(Calendar.WEEK_OF_YEAR)
}

fun String.toDate(): Date{
    val date = this.split('-').map{ it.toInt()}
    val year = date[0]
    val month = date[1]
    val day = date[2]
    return Date.from(PersianDate.of(year, month , day).toGregorian().atStartOfDay(ZoneId.systemDefault()).toInstant())
}
