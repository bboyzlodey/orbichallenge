package business.converter

import client.business.converter.DateTimeConverter
import kotlin.test.Test
import kotlin.test.assertEquals

/**
 *  Warning!
 *  Test couldn't to launch.
 *  TODO: Fix module build
 *
 *  Update 25.10.2021:
 *  You can launch test, if comment plugin "com.android.library" and uncomment version of all
 *  plugins in build.gradle :shared.
 * */
class DateTimeConverterTest {

    private val converter = DateTimeConverter()

    @Test
    fun fromNetwork_MoscowTimeZone() {
        // mock
        val serverUTCDateTime = "2020-06-01T10:19:44.475Z"
        val moscowDateTime = "2020-06-01T13:19:44.475"

        // action
        val result = converter.fromServer(serverUTCDateTime).toString()
        val actualResult = moscowDateTime

        // verify
        assertEquals(result, actualResult)
    }

    @Test
    fun toNetwork_MoscowTimeZone() {
        // mock
        val moscowDateTime = "2020-06-01T13:19:44.475"
        val serverUTCDateTime = "2020-06-01T10:19:44.475Z"

        // action
        val result = converter.toServer(moscowDateTime).toString()
        val actualResult = serverUTCDateTime

        // verify
        assertEquals(result, actualResult)
    }
}