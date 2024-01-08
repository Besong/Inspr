package com.besonganong.listquotesfeature.model

import kotlinx.serialization.Serializable


/**
 * Model class that represents a NewQuote from zenquotes.io API
 */
@Serializable
data class NewQuoteModel(val q: String, val a: String, val c: String, val h: String)