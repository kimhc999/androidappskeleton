package com.example.androidappskeleton.mock

import com.example.androidappskeleton.services.TextService

/**
 * Assume that TextService is dependent with unmanaged environment(network, db, etc.)
 * in these cases, make mock service to test it.
 */
class MockTextService : TextService {
    override fun getStringLength(query: String?): Int {
        return query?.length ?: 0
    }
}