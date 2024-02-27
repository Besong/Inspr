package com.besonganong

import android.app.Application
import com.besonganong.di.DependencyInjector
import com.besonganong.navigation.di.navigationModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin

const val INJECTOR_CLASS = "com.besonganong.listquotesfeature.di.DependencyInjectorImpl"

class InsprApplication: Application(){

    private lateinit var dependencyInjector: DependencyInjector

    // init
    override fun onCreate() {
        super.onCreate()

        initDependency()

        startKoin {
            androidContext(this@InsprApplication)
            androidLogger()

            loadKoinModules(
                listOf(
                    dependencyInjector.getDependencies(),
                    navigationModules
                )
            )


        }
    }

    private fun initDependency() {
        dependencyInjector =
            (Class.forName(INJECTOR_CLASS)
                .kotlin
                .objectInstance as DependencyInjector)

    }
}