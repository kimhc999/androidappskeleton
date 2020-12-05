package com.example.androidappskeleton.views.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidappskeleton.services.DispatchersService
import com.example.androidappskeleton.services.TextService
import com.example.androidappskeleton.utils.Event
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel @ViewModelInject constructor(
    private val textService: TextService,
    private val dispatchersService: DispatchersService
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

    fun calculate() {
        viewModelScope.launch {
            withContext(dispatchersService.io) {
                val length = textService.getStringLength(testText.value)
                _message.postValue(length.toString())
            }
        }
    }

    fun isOkButtonEnabled(testText: String): Boolean {
        return testText.isNotBlank()
    }
}