package com.hieuminh.lovejourney.models

import java.util.*

data class SimpleDate(val year: Int, val month: Int, val day: Int) {
    companion object {
        fun now(): SimpleDate {
            val calendar = GregorianCalendar()
            return fromCalendar(calendar)
        }

        fun fromCalendar(calendar: Calendar): SimpleDate {
            return SimpleDate(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH))
        }
    }
}

