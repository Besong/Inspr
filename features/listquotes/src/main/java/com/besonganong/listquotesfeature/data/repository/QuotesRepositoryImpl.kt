package com.besonganong.listquotesfeature.data.repository

import com.besonganong.listquotesfeature.data.remote.datasource.QuotesRemoteDataSource

import com.besonganong.listquotesfeature.data.remote.mapper.ClientMapper
import com.besonganong.listquotesfeature.model.QuoteModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.shareIn


class QuotesRepositoryImpl(
    private val quotesRemoteDataSource: QuotesRemoteDataSource,
    private val clientMapper: ClientMapper,
    private val externalScope: CoroutineScope
): QuotesRepository {
    override fun getQuotes(): Flow<List<QuoteModel>> = flow {

        val newQuoteModels = quotesRemoteDataSource.getNewQuotes()

        val quoteModels = clientMapper.mapQuoteModels(newQuoteModels = newQuoteModels)

        emit(quoteModels)

    }   // Making the cold flow hot by returning a SharedFlow
        .shareIn(
        scope = externalScope,
        replay = 1,
        started = SharingStarted.WhileSubscribed()
    )
}