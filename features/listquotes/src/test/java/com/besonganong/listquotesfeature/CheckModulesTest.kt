package com.besonganong.listquotesfeature

import com.besonganong.listquotesfeature.di.quotesModules
import com.besonganong.navigation.NavigationManager
import org.junit.Test
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.test.KoinTest
import org.koin.test.verify.verify

class CheckModulesTest: KoinTest {

    @OptIn(KoinExperimentalAPI::class)
    @Test
    fun check_app_modules() {
        quotesModules.verify(extraTypes = listOf( NavigationManager::class))
    }
}