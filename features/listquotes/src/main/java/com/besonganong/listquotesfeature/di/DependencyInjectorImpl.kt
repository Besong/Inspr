package com.besonganong.listquotesfeature.di

import com.besonganong.di.DependencyInjector
import org.koin.core.module.Module

/**
 * Class responsible for providing dependency
 */
object DependencyInjectorImpl: DependencyInjector {

    override fun getDependencies(): Module = quotesModules

}