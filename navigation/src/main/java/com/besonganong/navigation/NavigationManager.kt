package com.besonganong.navigation

import com.besonganong.navigation.destinations.NavigationDestinations.Default
import kotlinx.coroutines.flow.MutableStateFlow

/**
 * Class that uses NavigationCommand to navigate to different
 * Navigation Destinations.
 */
class NavigationManager {
    var commands = MutableStateFlow(Default)

    fun navigate(
        destinations: NavigationCommand
    ) {
        commands.value = destinations
    }
}