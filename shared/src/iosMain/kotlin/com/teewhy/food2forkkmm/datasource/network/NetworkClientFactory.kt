package com.teewhy.food2forkkmm.datasource.network

import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.engine.HttpClientEngineFactory
import io.ktor.client.engine.darwin.Darwin

actual val httpClientEngineConfig: HttpClientEngineFactory<HttpClientEngineConfig>
    get() = Darwin
