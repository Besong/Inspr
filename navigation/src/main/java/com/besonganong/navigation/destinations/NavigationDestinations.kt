package com.besonganong.navigation.destinations

import androidx.navigation.NamedNavArgument
import com.besonganong.navigation.NavigationCommand

/**
 * Destinations of different Composables across the app.
 */
object NavigationDestinations {

    val Default = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = ""
    }

    val quote = object : NavigationCommand {

        override val arguments  = emptyList<NamedNavArgument>()

        override val destination = "quotes"
    }


}