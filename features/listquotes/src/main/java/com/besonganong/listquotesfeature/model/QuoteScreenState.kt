package com.besonganong.listquotesfeature.model

import androidx.annotation.StringRes

/**
 *  Class representing the different UI states of QuotesScreen:
 *  Loading, Error and Success
 */
sealed class QuotesScreenState {
    data class Success(val quoteModels: List<QuoteModel>): QuotesScreenState()
    data class Error(@StringRes val resId: Int): QuotesScreenState()
    data object Loading: QuotesScreenState()
}
