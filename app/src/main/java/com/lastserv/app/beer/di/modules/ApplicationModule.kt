package com.lastserv.app.beer.di.modules

import android.app.Application
import android.content.Context
import com.lastserv.app.beer.BuildConfig
import com.lastserv.app.beer.UiThread
import com.lastserv.app.beer.cache.BeerCacheImpl
import com.lastserv.app.beer.cache.PreferencesHelper
import com.lastserv.app.beer.cache.mapper.BeerEntityMapper
import com.lastserv.app.beer.data.BeerDataRepository
import com.lastserv.app.beer.data.executor.JobExecutor
import com.lastserv.app.beer.data.mapper.BeerMapper
import com.lastserv.app.beer.data.repository.BeerCache
import com.lastserv.app.beer.data.repository.BeerRemote
import com.lastserv.app.beer.data.source.BeerDataStoreFactory
import com.lastserv.app.beer.di.scopes.PerApplication
import com.lastserv.app.beer.domain.executor.PostExecutionThread
import com.lastserv.app.beer.domain.executor.ThreadExecutor
import com.lastserv.app.beer.domain.repository.BeerRepository
import com.lastserv.app.beer.remote.BeerRemoteImpl
import com.lastserv.app.beer.remote.BeerService
import com.lastserv.app.beer.remote.BeerServiceFactory
import dagger.Module
import dagger.Provides
import io.realm.Realm
import io.realm.RealmConfiguration

/**
 * @author Rodrigo Garcete
 * @version 0.0.1
 * Copyright 2018. All rights reserved
 * Module used to provide dependencies at an application-level.
*/
@Module
open class ApplicationModule {

    @Provides
    @PerApplication
    fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @PerApplication
    internal fun providePreferencesHelper(context: Context): PreferencesHelper {
        return PreferencesHelper(context)
    }

    @Provides
    @PerApplication
    internal fun provideRealm(context: Context): Realm {
        Realm.init(context)
        val realmConfiguration = RealmConfiguration.Builder()
                .name("beers.realm")
                .schemaVersion(1)
                .deleteRealmIfMigrationNeeded()
                //.initialData(RealmInitialData())
                //.migration()
                .build()

        Realm.setDefaultConfiguration(realmConfiguration)

        return Realm.getDefaultInstance()
    }

    @Provides
    @PerApplication
    internal fun provideBeerCache(realm: Realm,
                                  entityMapper: BeerEntityMapper,
                                  helper: PreferencesHelper): BeerCache {
        return BeerCacheImpl(realm, entityMapper, helper)
    }

    @Provides
    @PerApplication
    internal fun provideBeerRemote(service: BeerService,
                                   factory: com.lastserv.app.beer.remote.mapper.BeerEntityMapper): BeerRemote {
        return BeerRemoteImpl(service, factory)
    }

    @Provides
    @PerApplication
    internal fun provideBeerRepository(factory: BeerDataStoreFactory,
                                       mapper: BeerMapper): BeerRepository {
        return BeerDataRepository(factory, mapper)
    }

    @Provides
    @PerApplication
    internal fun provideThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor {
        return jobExecutor
    }

    @Provides
    @PerApplication
    internal fun providePostExecutionThread(uiThread: UiThread): PostExecutionThread {
        return uiThread
    }

    @Provides
    @PerApplication
    internal fun provideBeerService(): BeerService {
        return BeerServiceFactory.makeBeerService(BuildConfig.DEBUG)
    }
}