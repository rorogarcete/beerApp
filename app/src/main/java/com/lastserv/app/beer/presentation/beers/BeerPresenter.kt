package com.lastserv.app.beer.presentation.beers

import io.reactivex.observers.DisposableSingleObserver
import com.lastserv.app.beer.domain.interactor.base.SingleUseCase
import com.lastserv.app.beer.domain.model.Beer
import com.lastserv.app.beer.presentation.mapper.BeerMapper
import javax.inject.Inject

class BeerPresenter @Inject constructor(val beerView: BeerContract.View,
                                        val getBeersUseCase: SingleUseCase<List<Beer>, Void>,
                                        val beerMapper: BeerMapper): BeerContract.Presenter {

    init {
        beerView.setPresenter(this)
    }

    override fun start() {
        retrieveBeers()
    }

    override fun stop() {
        getBeersUseCase.dispose()
    }

    override fun retrieveBeers() {
        getBeersUseCase.execute(BeerSubscriber())
    }

    inner class BeerSubscriber: DisposableSingleObserver<List<Beer>>() {

        override fun onSuccess(t: List<Beer>) {
            handleGetBeersSuccess(t)
        }

        override fun onError(exception: Throwable) {
            beerView.hideBeers()
            beerView.hideEmptyState()
            beerView.showErrorState()
        }

    }

    internal fun handleGetBeersSuccess(beers: List<Beer>) {
        beerView.hideErrorState()
        if (beers.isNotEmpty()) {
            beerView.hideEmptyState()
            beerView.showBeers(beers.map { beerMapper.mapToView(it) })
        } else {
            beerView.hideBeers()
            beerView.showEmptyState()
        }
    }

}