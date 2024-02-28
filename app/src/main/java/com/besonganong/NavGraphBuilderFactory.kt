package com.besonganong

import androidx.navigation.NavGraphBuilder

interface NavGraphBuilderFactory {

    interface QuotesScreenNavComposable {
        fun NavGraphBuilder.quotesScreen()
    }
}