package com.example.everfittest.utils

import java.util.*

object DateUtils {

    fun getCalendar(): Calendar {
        return Calendar.getInstance(TimeZone.getDefault())
    }

    fun isSameDate(calendar1: Calendar, calendar2: Calendar): Boolean {
        return calendar1.get(Calendar.DAY_OF_YEAR) == calendar2.get(Calendar.DAY_OF_YEAR) &&
                calendar1.get(Calendar.YEAR) == calendar2.get(Calendar.YEAR)
    }

    fun getRangeByWeek(): List<Calendar> {
        val calendar = getCalendar()
        val lastWeek = calendar.get(Calendar.WEEK_OF_YEAR)
        val year = calendar.get(Calendar.YEAR)
        val startCalendar = getCalendar().apply {
            clear() // start at 00:00
            set(Calendar.WEEK_OF_YEAR, lastWeek)
            set(Calendar.YEAR, year)
            add(Calendar.DATE, 1)
        }
        val dates = arrayListOf<Calendar>()
        for (day in 0 until 7) {
            val newData: Calendar = startCalendar.clone() as Calendar
            newData.apply {
                add(Calendar.DATE, day)
            }.also { dates.add(it) }
        }

        return dates
    }

    fun convertDateToEE(date: Int): String {
        when (date) {
            1 -> return "SUN"
            2 -> return "MON"
            3 -> return "TUE"
            4 -> return "WED"
            5 -> return "THU"
            6 -> return "FRI"
            7 -> return "SAT"
            else -> return "Error"
        }
    }
}