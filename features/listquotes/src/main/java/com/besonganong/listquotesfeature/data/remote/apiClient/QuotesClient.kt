package com.besonganong.listquotesfeature.data.remote.apiClient

import com.besonganong.listquotesfeature.model.NewQuoteModel
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer

/**
 * An Http client responsible for performing network calls.
 */
val quotesHttpClient = HttpClient(Android) {

    // Plugin for content negotiation.
    install(ContentNegotiation) {

         json(Json {
            prettyPrint = true
            isLenient = true
            ignoreUnknownKeys = true
        })

        serializer<NewQuoteModel>()
    }

    // Plugin for Logging at the network side.
    install(Logging)
}