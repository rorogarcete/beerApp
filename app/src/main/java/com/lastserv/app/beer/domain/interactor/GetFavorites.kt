package com.lastserv.app.beer.domain.interactor

import com.lastserv.app.beer.domain.executor.PostExecutionThread
import com.lastserv.app.beer.domain.executor.ThreadExecutor
import com.lastserv.app.beer.domain.interactor.base.SingleUseCase
import com.lastserv.app.beer.domain.model.BeerFavorite
import com.lastserv.app.beer.domain.repository.BeerRepository
import io.reactivex.Single
import javax.inject.Inject

/**
 * Use case used for retreiving a [List] of [BeerFavorite] instances from the [BeerRepository]
 */
open class GetBufferoos @Inject constructor(val beerRepository: BeerRepository,
                                            threadExecutor: ThreadExecutor,
                                            postExecutionThread: PostExecutionThread):
        SingleUseCase<List<BeerFavorite>, Void?>(threadExecutor, postExecutionThread) {

    public override fun buildUseCaseObservable(params: Void?): Single<List<BeerFavorite>> {
        return beerRepository.getFavorites()
    }

}