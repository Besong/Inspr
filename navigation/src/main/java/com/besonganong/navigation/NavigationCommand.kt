package com.besonganong.navigation

import androidx.navigation.NamedNavArgument

/**
 * Contract/Interface that defines the requirements of a navigation event.
 */
interface NavigationCommand {

    val arguments: List<NamedNavArgument>

    val destination: String
}