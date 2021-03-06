package com.lastserv.app.beer.presentation.beers

import com.lastserv.app.beer.presentation.BasePresenter
import com.lastserv.app.beer.presentation.BaseView
import com.lastserv.app.beer.presentation.model.BeerView

/**
 * Defines a contract of operations between the BeerPresenter and Beer View
 */
interface BeerContract {

    interface View : BaseView<Presenter> {

        fun showProgress()

        fun hideProgress()

        fun showBeers(beers: List<BeerView>)

//        fun checkFavoriteBeer(beer: BeerView)

        fun hideBeers()

        fun showErrorState()

        fun hideErrorState()

        fun showEmptyState()

        fun hideEmptyState()

    }

    interface Presenter : BasePresenter {
        fun retrieveBeers()
    }

}