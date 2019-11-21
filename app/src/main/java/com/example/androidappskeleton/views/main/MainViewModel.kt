package com.example.androidappskeleton.views.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidappskeleton.services.TempService
import com.example.androidappskeleton.utils.Event
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val tempService: TempService
) : ViewModel() {
    val testText = MutableLiveData<String>()
    private val _successEvent = MutableLiveData<Event<String>>()
    val successEvent: LiveData<Event<String>> = _successEvent
    private val _failedEvent = MutableLiveData<Event<Unit>>()
    val failedEvent: LiveData<Event<Unit>> = _failedEvent
    private val _message = MutableLiveData<String>()
    val message: LiveData<String> = _message

    init {
        testText.value = ""
        _message.value = ""
    }

    fun login() {
        if(testText.value == null) return
        tempService.runTest(
            test = testText.value!!,
            successCallback = {
                _successEvent.value = Event(testText.value!!)
                _message.value = testText.value
            },
            failedCallback = {
                _failedEvent.value = Event(Unit)
            })

    }

    fun isOkButtonEnabled(testText: String): Boolean {
        return !testText.isBlank()
    }
}