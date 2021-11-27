package client.core

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

internal actual fun getDispatcherIO(): CoroutineDispatcher {
    return Dispatchers.IO
}