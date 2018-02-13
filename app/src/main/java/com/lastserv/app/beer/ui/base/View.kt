package com.mobile.exercise.app.ui.base

/**
 * @author Rodrigo Garcete
 * @version 0.0.1
 * Copyright 2018. All rights reserved
 * Base interface for views
 */
interface View {
    fun showProgress()
    fun hideProgress()
    fun showError(msg: String)
}