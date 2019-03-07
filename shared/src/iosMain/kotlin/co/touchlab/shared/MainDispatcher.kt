package co.touchlab.shared

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Runnable
import platform.darwin.dispatch_async
import platform.darwin.dispatch_get_main_queue
import kotlin.coroutines.CoroutineContext
import kotlin.native.concurrent.freeze

internal actual val MainDispatcher = object : CoroutineDispatcher() {
    override fun dispatch(context: CoroutineContext, block: Runnable) {
        dispatch_async(dispatch_get_main_queue().freeze()) {
            block.run()
        }
    }
}