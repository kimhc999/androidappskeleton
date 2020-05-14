package com.example.androidappskeleton.di

import com.example.androidappskeleton.services.DispatchersService
import com.example.androidappskeleton.services.TextService
import com.example.androidappskeleton.views.main.MainFragment
import com.example.androidappskeleton.views.main.MainViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules=[
    TestModule::class,
    ViewModelModule::class])
interface ApplicationComponent {
    fun inject(mainFragment: MainFragment)
    fun inject(textService: TextService)
    fun inject(dispatchersService: DispatchersService)
}