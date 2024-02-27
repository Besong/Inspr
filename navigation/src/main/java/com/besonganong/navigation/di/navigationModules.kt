package com.besonganong.navigation.di

import com.besonganong.navigation.NavigationManager
import org.koin.dsl.module

/**
 * Navigation components that can be injected by Koin into other classes or by Android Components
 * e.g Activities, Application etc..
 */
val navigationModules = module {

    // Navigation Manager
    single {
        NavigationManager()
    }

}