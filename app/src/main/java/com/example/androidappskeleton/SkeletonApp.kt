package com.example.androidappskeleton

import android.app.Application
import com.example.androidappskeleton.di.ApplicationComponent
import com.example.androidappskeleton.di.DaggerApplicationComponent

class SkeletonApp : Application() {
    val appComponent: ApplicationComponent = DaggerApplicationComponent.create()
}