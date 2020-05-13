package com.example.androidappskeleton.mock

import com.example.androidappskeleton.services.DispatchersService
import kotlinx.coroutines.CoroutineDispatcher

class TestDispatcherService(private val testDispatcher: CoroutineDispatcher): DispatchersService {
    override val main: CoroutineDispatcher
        get() = testDispatcher
    override val io: CoroutineDispatcher
        get() = testDispatcher
    override val default: CoroutineDispatcher
        get() = testDispatcher
}