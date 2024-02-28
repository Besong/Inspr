package com.besonganong.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.besonganong.navigation.Destinations.QUOTES

/**
 * Contains the different app destinations
 */

@Composable
fun InsprAppNavigation() {

    val navController = rememberNavController()
    val actions = remember(navController) {Actions(navController)}

    NavHost(navController = navController, startDestination = QUOTES) {

        composable(route = QUOTES) {
            //QuotesScreen(quotesViewModel = koinViewModel())
        }
    }
}