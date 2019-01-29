package com.arturszymanski.basiskotlinmvp

import android.app.Application
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso

/**
 * BKMVP Application class
 */
class BKMVPApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        //TODO replace later
        var builder : Picasso.Builder= Picasso.Builder(baseContext)
            .downloader(OkHttp3Downloader(baseContext))

        if (BuildConfig.DEBUG) {
            builder.listener { _, _, exception -> exception.printStackTrace() }
            builder.loggingEnabled(true)
            builder.indicatorsEnabled(true)
        }

        var picasso : Picasso = builder.build()
        Picasso.setSingletonInstance(picasso)
    }
}