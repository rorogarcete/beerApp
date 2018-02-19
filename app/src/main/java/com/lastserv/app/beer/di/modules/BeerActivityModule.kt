package com.lastserv.app.beer.di.modules

import com.lastserv.app.beer.di.scopes.PerActivity
import com.lastserv.app.beer.domain.interactor.GetBeers
import com.lastserv.app.beer.ui.beers.BeerActivity
import com.lastserv.app.beer.presentation.beers.BeerContract
import com.lastserv.app.beer.presentation.beers.BeerPresenter
import com.lastserv.app.beer.ui.mapper.BeerMapper
import dagger.Module
import dagger.Provides


/**
 * Module used to provide dependencies at an activity-level.
 */
@Module
open class BeerActivityModule {

    @PerActivity
    @Provides
    internal fun provideBrowseView(beerActivity: BeerActivity): BeerContract.View {
        return beerActivity
    }

    @PerActivity
    @Provides
    internal fun provideBeerPresenter(mainView: BeerContract.View,
                                      getBeers: GetBeers, mapper: BeerMapper):
            BeerContract.Presenter {
        return BeerPresenter(mainView, getBeers, mapper)
    }

}
