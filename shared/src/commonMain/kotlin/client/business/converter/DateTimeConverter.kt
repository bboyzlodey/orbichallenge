package client.business.converter

import kotlinx.datetime.*

class DateTimeConverter {
    private val currentTimeZone = TimeZone.currentSystemDefault()
    fun fromServer(dateTime: String): LocalDateTime = dateTime.toInstant().toLocalDateTime(currentTimeZone)
    fun toServer(localDateTime: LocalDateTime): Instant = localDateTime.toInstant(currentTimeZone)
    fun toServer(localDateTime: String): Instant = localDateTime.toLocalDateTime().toInstant(currentTimeZone)
}