package com.hieuminh.lovejourney.utils

import android.os.Build
import androidx.annotation.RequiresApi
import com.hieuminh.lovejourney.models.SimpleDate
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.ResolverStyle
import java.util.*
import kotlin.math.roundToInt

object DateUtil {
    fun getDateCount(date: String, pattern: String): Int {
        val timeStamp = convertStringToDate(date, pattern)?.time ?: return 0
        val currentTimeStamp = Calendar.getInstance().timeInMillis
        val millionSeconds = currentTimeStamp - timeStamp
        return (millionSeconds / (1000.0 * 60 * 60 * 24)).roundToInt()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun convertLocalDateToString(date: LocalDate, pattern: String): String? {
        return try {
            val formatter = DateTimeFormatter.ofPattern(pattern)
            date.format(formatter)
        } catch (e: java.lang.Exception) {
            null
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun convertStringToLocalDate(value: String, pattern: String): LocalDate? {
        if (value.length != pattern.length) return null
        return try {
            val replacedPattern = pattern.replace("y", "u").replace("Y", "U")
            val formatter = DateTimeFormatter.ofPattern(replacedPattern, Locale.US)
                .withResolverStyle(ResolverStyle.STRICT)
            LocalDate.parse(value, formatter)
        } catch (e: java.lang.Exception) {
            null
        }
    }

    fun convertDateToString(date: Date, pattern: String): String? {
        return try {
            val formatter = SimpleDateFormat(pattern)
            formatter.format(date)
        } catch (e: java.lang.Exception) {
            null
        }
    }

    fun convertStringToDate(value: String, pattern: String): Date? {
        if (value.length != pattern.length) return null
        return try {
            val formatter = SimpleDateFormat(pattern)
            return formatter.parse(value)
        } catch (e: java.lang.Exception) {
            null
        }
    }

    fun convertDateStringToSimpleDate(dateString: String, pattern: String) : SimpleDate? {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val dateValue = convertStringToLocalDate(dateString, pattern)
            dateValue?.let { SimpleDate(dateValue.year, dateValue.monthValue - 1, dateValue.dayOfMonth) }
        } else {
            val calendar = GregorianCalendar()
            val dateValue = convertStringToDate(dateString, pattern)
            dateValue?.let {
                calendar.time = dateValue
                SimpleDate.fromCalendar(calendar)
            }
        }
    }

    fun getDayMonth(value: String, pattern: String): String? {
        val simpleDate = convertDateStringToSimpleDate(value, pattern)
        return simpleDate?.let { "${it.day}/${it.month}" }
    }
}
