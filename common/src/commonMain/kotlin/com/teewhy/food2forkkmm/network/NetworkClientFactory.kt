package com.teewhy.food2forkkmm.network

import cc.popkorn.annotations.InjectableProvider
import com.teewhy.food2forkkmm.base.BaseApi
import com.teewhy.food2forkkmm.base.BaseApi.Companion.EMPTY_STRING
import com.teewhy.food2forkkmm.base.BaseApi.Companion.TOKEN
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.engine.HttpClientEngineFactory
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.BearerTokens
import io.ktor.client.plugins.auth.providers.bearer
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

expect val httpClientEngineConfig: HttpClientEngineFactory<HttpClientEngineConfig>

@InjectableProvider
class NetworkClientFactory {
    fun build(): HttpClient {
        return HttpClient(httpClientEngineConfig) {
            install(ContentNegotiation) {
                json(
                    Json {
                        prettyPrint = true
                        isLenient = true
                        ignoreUnknownKeys = true
                    }
                )
            }
            install(Auth) {
                bearer {
                    BearerTokens(TOKEN, EMPTY_STRING)
                }
            }
        }
    }

    companion object {
        val baseUrl = BaseApi.BASE_URL
    }
}
