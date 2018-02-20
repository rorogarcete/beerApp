package com.lastserv.app.beer.ui.splash

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.lastserv.app.beer.ui.beers.BeerActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Start home activity
        startActivity(Intent(this, BeerActivity::class.java))
        // close splash activity
        finish()
    }
}
