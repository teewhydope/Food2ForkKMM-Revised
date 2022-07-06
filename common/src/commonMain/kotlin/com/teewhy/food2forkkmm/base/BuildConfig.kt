package com.teewhy.food2forkkmm.base

expect class BuildConfig {
    fun isDebug(): Boolean

    fun isAndroid(): Boolean // true is android client, false if iOS
}
