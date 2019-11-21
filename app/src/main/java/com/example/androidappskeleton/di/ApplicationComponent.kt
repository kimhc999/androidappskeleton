package com.example.androidappskeleton.di

import com.example.androidappskeleton.services.TempService
import com.example.androidappskeleton.views.main.MainFragment
import com.example.androidappskeleton.views.main.MainViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules=[TestModule::class])
interface ApplicationComponent {
    fun inject(mainFragment: MainFragment)
    fun inject(mainViewModel: MainViewModel)
    fun inject(tempService: TempService)
}