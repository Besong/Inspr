package com.besonganong.inspr

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.besonganong.NavGraphBuilderFactory
import com.besonganong.inspr.ui.theme.InsprTheme
import com.besonganong.navigation.NavigationManager
import com.besonganong.navigation.destinations.NavigationDestinations
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity(){

    private val navigationManager: NavigationManager by inject()
    private val quotesComposable: NavGraphBuilderFactory.QuotesScreenNavComposable by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            InsprTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val navController = rememberNavController()

                    val command by navigationManager.commands.collectAsState()

                    if (command.destination.isNotEmpty()) {
                        navController.navigate(command.destination)
                    }

                    NavHost(
                        navController = navController,
                        startDestination = NavigationDestinations.quote.destination) {

                        //QuotesScreen
                        quotesComposable.apply { quotesScreen() }
                    }
                }
            }
        }
    }
}