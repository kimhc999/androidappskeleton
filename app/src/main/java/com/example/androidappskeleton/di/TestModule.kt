package com.example.androidappskeleton.di

import com.example.androidappskeleton.services.AndroidDispatchersService
import com.example.androidappskeleton.services.DispatchersService
import com.example.androidappskeleton.services.LocalTextService
import com.example.androidappskeleton.services.TextService
import dagger.Binds
import dagger.Module

@Module
interface TestModule {
    @Binds
    fun provideTextService(userService: LocalTextService): TextService
    @Binds
    fun provideDispatchersService(dispatchersService: AndroidDispatchersService): DispatchersService
}