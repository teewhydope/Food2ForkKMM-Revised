package com.teewhy.food2forkkmm.base

import com.teewhy.food2forkkmm.BuildConfig.DEBUG

actual class BuildConfig {
    actual fun isDebug() = DEBUG
    actual fun isAndroid() = true
}
