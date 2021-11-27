package client.presentation.utils

import kotlinx.datetime.LocalDateTime

class DateTimeFormatter {
    private val twoDigitsFormat = "%2d"
    private val formatDDMM = "%s %s"
    fun formatDDMM(localDateTime: LocalDateTime): String =
        formatDDMM.format(
            twoDigitsFormat.format(localDateTime.dayOfMonth),
            twoDigitsFormat.format(localDateTime.monthNumber)
        )
}