package com.mobile.exercise.app.ui.base

/**
 * @author Rodrigo Garcete
 * @version 0.0.1
 * Copyright 2018. All rights reserved
 * Base interface for presenters
 */
interface Presenter<T : View> {
    fun attachView(t: T)
    fun detachView()
}