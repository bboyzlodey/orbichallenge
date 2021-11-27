package client.core

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

object Dispatchers {
    val IO: CoroutineDispatcher
        get() = getDispatcherIO()
    val main: CoroutineDispatcher
        get() = Dispatchers.Main
}
