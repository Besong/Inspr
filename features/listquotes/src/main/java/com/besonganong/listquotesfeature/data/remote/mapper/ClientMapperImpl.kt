package com.besonganong.listquotesfeature.data.remote.mapper

import com.besonganong.listquotesfeature.model.NewQuoteModel
import com.besonganong.listquotesfeature.model.QuoteModel

class ClientMapperImpl: ClientMapper {
    override fun mapQuoteModels(newQuoteModels: List<NewQuoteModel>): List<QuoteModel> =
        newQuoteModels.map { mapQuoteModel(it) }

    override fun mapQuoteModel(newQuoteModel: NewQuoteModel): QuoteModel =
        with(newQuoteModel) {
            QuoteModel(
                text = q,
                characterCount = c.toInt(),
                author = a)
        }
    }