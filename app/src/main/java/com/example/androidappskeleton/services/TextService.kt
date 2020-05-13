package com.example.androidappskeleton.services

import javax.inject.Inject
import javax.inject.Singleton

interface TextService {
    fun getStringLength(query: String?): Int
}

@Singleton
class LocalTextService @Inject constructor(): TextService {
    override fun getStringLength(query: String?): Int {
        Thread.sleep(3_000) // Assume it takes long time.
        return query?.length ?: 0
    }
}