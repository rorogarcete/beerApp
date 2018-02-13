package com.lastserv.app.beer.di.modules

import android.app.Application
import android.content.Context
import com.lastserv.app.beer.BeerApplication

import dagger.Module
import dagger.Provides

import javax.inject.Singleton

/**
 * @author Rodrigo Garcete
 * @version 0.0.1
 * Copyright 2018. All rights reserved
 */
@Module
class ApplicationModule(private val app: BeerApplication) {

    @Provides
    @Singleton
    fun provideApplicationContext(): Application = app

    @Provides
    @Singleton
    fun provideContext(): Context = app.baseContext

    @Provides
    fun provideDebugTree(): Timber.DebugTree = Timber.DebugTree()
}