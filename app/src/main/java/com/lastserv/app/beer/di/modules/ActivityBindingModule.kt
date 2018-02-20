package com.lastserv.app.beer.di.modules

import com.lastserv.app.beer.di.scopes.PerActivity
import com.lastserv.app.beer.ui.beers.BeerActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @PerActivity
    @ContributesAndroidInjector(modules = arrayOf(BeerActivityModule::class))
    abstract fun bindBeerActivity(): BeerActivity

}