package com.besonganong.listquotesfeature.data.remote.datasource

import com.besonganong.listquotesfeature.utils.QUOTES_URL
import com.besonganong.listquotesfeature.model.NewQuoteModel
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.utils.io.core.use
import kotlinx.coroutines.delay

class QuotesRemoteDataSource(
    private val client: HttpClient,
    private val delayInterval: Long = 2000L
) {
    suspend fun getNewQuotes(): List<NewQuoteModel> {
        // Add a delay of 2 seconds
        delay(delayInterval)

        return client.use {client ->
            client.get(QUOTES_URL).body()
        }
    }
}
