package com.lastserv.app.beer.domain.interactor

import com.lastserv.app.beer.domain.executor.PostExecutionThread
import com.lastserv.app.beer.domain.executor.ThreadExecutor
import com.lastserv.app.beer.domain.interactor.base.SingleUseCase
import com.lastserv.app.beer.domain.model.Beer
import com.lastserv.app.beer.domain.repository.BeerRepository

import io.reactivex.Single

import javax.inject.Inject

/**
 * Use case used for retreiving a [List] of [Beer] instances from the [BeerRepository]
 */
open class GetBeers @Inject constructor(val beerRepository: BeerRepository,
                                            threadExecutor: ThreadExecutor,
                                            postExecutionThread: PostExecutionThread):
        SingleUseCase<List<Beer>, Void?>(threadExecutor, postExecutionThread) {

    public override fun buildUseCaseObservable(params: Void?): Single<List<Beer>> {
        return beerRepository.getBeers()
    }

}