package com.tusharp161.kotlinbootcamp

import android.annotation.SuppressLint
import com.tusharp161.kotlinbootcamp.di.DaggerAppComponent
import dagger.android.DaggerApplication

/**
 * This class is representation of [Application] and [DaggerApplication], It handles the global
 * Application state.
 */
@SuppressLint("Registered")
class BootcampApplication : DaggerApplication() {

    /**
     * Instance of [DaggerAppComponent]
     */
    private val appComponent = DaggerAppComponent.factory().application(this)

    @SuppressWarnings("Unused")
    override fun onCreate() {
        super.onCreate()
    }

    override fun applicationInjector() = appComponent
}