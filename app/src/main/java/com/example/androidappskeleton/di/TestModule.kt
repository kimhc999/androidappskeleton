package com.example.androidappskeleton.di

import com.example.androidappskeleton.services.LocalTempService
import com.example.androidappskeleton.services.TempService
import dagger.Binds
import dagger.Module

@Module
interface TestModule {
    @Binds
    fun provideFirebaseUserService(userService: LocalTempService): TempService
}