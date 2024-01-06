package com.besonganong.listquotesfeature.model

/**
 *  Class representing the different UI states of QuotesScreen:
 *  Loading, Error and Success
 */
sealed class QuotesScreenState {
    data class Success(val quoteModels: List<QuoteModel>): QuotesScreenState()
    data object Error: QuotesScreenState()
    data object Loading: QuotesScreenState()
}
