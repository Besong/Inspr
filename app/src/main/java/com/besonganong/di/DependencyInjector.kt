package com.besonganong.di

import org.koin.core.module.Module

interface DependencyInjector {
    fun getDependencies(): Module
}