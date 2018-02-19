package com.lastserv.app.beer.di.components

import com.lastserv.app.beer.ui.beers.BeerActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent
interface BeerActivitySubComponent : AndroidInjector<BeerActivity> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<BeerActivity>()

}