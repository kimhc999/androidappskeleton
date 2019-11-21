package com.example.androidappskeleton

import android.app.Application
import com.example.androidappskeleton.di.DaggerApplicationComponent

class SkeletonApp : Application() {
    val appComponent = DaggerApplicationComponent.create()
    override fun onCreate() {
        super.onCreate()
    }
}