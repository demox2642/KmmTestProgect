package ktor

import io.ktor.client.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import org.koin.dsl.module

val ktorModule =
    module {
        single<HttpClient> {
            HttpClient(HttpEngineFactory().createEngine()) {
                install(Logging) {
                    logger = Logger.SIMPLE
                    level = LogLevel.ALL
                }

                install(DefaultRequest)

                install(ContentNegotiation) {
                    json(
                        Json {
                            isLenient = true
                            ignoreUnknownKeys = true
                            prettyPrint = true
                        },
                    )
                }

                install(HttpTimeout) {
                    connectTimeoutMillis = 15000
                    requestTimeoutMillis = 30000
                }

                defaultRequest {
                    url("https://api.github.com")
                    header("Content-Type", "application/json; charset=UTF-8")
                }
            }
        }
    }
