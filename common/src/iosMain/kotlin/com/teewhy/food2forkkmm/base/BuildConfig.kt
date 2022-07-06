package com.teewhy.food2forkkmm.base

actual class BuildConfig {
    actual fun isDebug() = Platform.isDebugBinary
    actual fun isAndroid() = false
}
