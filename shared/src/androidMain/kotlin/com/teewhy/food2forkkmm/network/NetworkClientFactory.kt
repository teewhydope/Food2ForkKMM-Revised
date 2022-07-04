package com.teewhy.food2forkkmm.network

import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.engine.HttpClientEngineFactory
import io.ktor.client.engine.android.Android

actual val httpClientEngineConfig: HttpClientEngineFactory<HttpClientEngineConfig>
    get() = Android
