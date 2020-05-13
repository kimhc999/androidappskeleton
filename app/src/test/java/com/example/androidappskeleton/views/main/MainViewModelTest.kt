package com.example.androidappskeleton.views.main

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.androidappskeleton.util.MainCoroutineRule
import com.example.androidappskeleton.mock.MockTextService
import com.example.androidappskeleton.mock.TestDispatcherService
import com.example.androidappskeleton.services.TextService
import com.example.androidappskeleton.util.LiveDataTestUtil
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi

class MainViewModelTest {
    private lateinit var mainViewModel: MainViewModel

    private lateinit var textService: TextService


    private val testDispatcher = TestCoroutineDispatcher()

    // Set the main coroutines dispatcher for unit testing.
    @get:Rule
    var coroutineRule = MainCoroutineRule()
    // Executes each task synchronously using Architecture Components.
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        textService = MockTextService()
        val dispatcherService = TestDispatcherService(testDispatcher)
        mainViewModel = MainViewModel(textService, dispatcherService)
    }

    @Test
    fun calculateTest() = coroutineRule.runBlockingTest {
        mainViewModel.testText.value = "test"
        mainViewModel.calculate()
        assertThat(LiveDataTestUtil.getValue(mainViewModel.message)).isEqualTo("4")
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }
}