package com.besonganong.listquotesfeature.data.repository

import com.besonganong.listquotesfeature.model.QuoteModel
import kotlinx.coroutines.flow.Flow

/**
 * A simple interface abstraction responsible for communicating with the
 * Zenquotes.io Quotes API
 */
interface QuotesRepository {
    fun getQuotes(): Flow<List<QuoteModel>>
}