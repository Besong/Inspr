package com.besonganong.listquotesfeature.model

/**
 * Class that models a Quote from the zenquotes.io API
 */
data class Quote(var text: String, var characterCount: Int, var author: String)
