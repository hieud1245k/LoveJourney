package com.hieuminh.lovejourney.utils

import android.os.Build
import androidx.annotation.RequiresApi
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
}
