package com.besonganong.listquotesfeature.data.remote.mapper

import com.besonganong.listquotesfeature.model.NewQuoteModel
import com.besonganong.listquotesfeature.model.QuoteModel

interface ClientMapper {

    // NewQuoteModel -> QuoteModel
    fun mapQuoteModel(newQuoteModel: NewQuoteModel): QuoteModel

    fun mapQuoteModels(newQuoteModels: List<NewQuoteModel>): List<QuoteModel>
}