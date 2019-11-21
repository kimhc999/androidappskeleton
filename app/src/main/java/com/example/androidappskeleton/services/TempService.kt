package com.example.androidappskeleton.services

import javax.inject.Inject
import javax.inject.Singleton

interface TempService {
    fun runTest(test: String,
                successCallback: (()->Unit),
                failedCallback: ()->Unit)
    var testText: String
}

@Singleton
class LocalTempService @Inject constructor(): TempService {
    override lateinit var testText: String
    init {
        testText = "test"
    }
    override fun runTest(test: String, successCallback: () -> Unit, failedCallback: () -> Unit) {
        testText = test
        successCallback.invoke()
    }
}