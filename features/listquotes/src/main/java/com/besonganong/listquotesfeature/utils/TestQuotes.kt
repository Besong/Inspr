package com.besonganong.listquotesfeature.utils

import com.besonganong.listquotesfeature.model.QuoteModel

/**
 * A singleton quotes class responsible for provided static quotes for test purposes.
 */
object TestQuotes {

    val quoteModel1 =
        QuoteModel("The strongest and sweetest songs yet remain to be sung.",
            23,
            "Walt")

    val quoteModel2 =
        QuoteModel("Re-examine all that you have been told... dismiss that which insults your soul.",
            34,
            "Walt")

    val quoteModel3 =
        QuoteModel("I am not what happened to me, I am what I choose to become.",
            34,
            "Carl-Jung")

    val quoteModel4 =
        QuoteModel("Your visions will become clear only when you can look into your own heart. Who looks outside, dreams; who looks inside, awakes.",
            23,
            "Carl-Jung")

}