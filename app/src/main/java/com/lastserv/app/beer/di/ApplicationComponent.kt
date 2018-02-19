package com.lastserv.app.beer.di

import android.app.Application
import com.lastserv.app.beer.BeerApplication
import com.lastserv.app.beer.di.modules.ActivityBindingModule
import com.lastserv.app.beer.di.modules.ApplicationModule
import com.lastserv.app.beer.di.scopes.PerApplication
import dagger.BindsInstance
import dagger.Component

import dagger.android.support.AndroidSupportInjectionModule

@PerApplication
@Component(modules = arrayOf(ActivityBindingModule::class, ApplicationModule::class,
        AndroidSupportInjectionModule::class))
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance fun application(application: Application): Builder
        fun build(): ApplicationComponent
    }

    fun inject(app: BeerApplication)

}
