package com.besonganong.listquotesfeature

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.besonganong.NavGraphBuilderFactory
import com.besonganong.listquotesfeature.view.ui.screens.QuotesScreen
import com.besonganong.navigation.destinations.NavigationDestinations

class QuotesScreenNavComposableImpl:
    NavGraphBuilderFactory.QuotesScreenNavComposable {

    override fun NavGraphBuilder.quotesScreen() {

        composable(route = NavigationDestinations.quote.destination) {
            QuotesScreen()
        }

    }
}