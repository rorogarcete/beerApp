package com.lastserv.app.beer.presentation.beers

import com.lastserv.app.beer.presentation.BasePresenter
import com.lastserv.app.beer.presentation.BaseView
import com.lastserv.app.beer.ui.model.BeerViewModel

/**
 * Defines a contract of operations between the BeerPresenter and Beer View
 */
interface BeerContract {

    interface View : BaseView<Presenter> {

        fun showProgress()

        fun hideProgress()

        fun showBeers(beers: List<BeerViewModel>)

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