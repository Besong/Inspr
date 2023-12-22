package com.besonganong.listquotesfeature.model

/**
 * Class defining whether QuotesScreen is:
 * Loading to show quotes, or Has an Error, or Is successfully displaying quotes.
 */
sealed class QuotesScreenState {
    data class Success(var quotes: List<Quote>): QuotesScreenState()
    data class Error(val errorMsg: String): QuotesScreenState()
    object Loading: QuotesScreenState()
}
