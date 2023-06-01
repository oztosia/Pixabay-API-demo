package com.oztosia.pixabay_api_demo.core.base

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hadilq.liveevent.LiveEvent
import com.oztosia.pixabay_api_demo.core.error.ErrorMapper

open class BaseViewModel(private val errorMapper: ErrorMapper? = null) : ViewModel(), DefaultLifecycleObserver {

    private val _message by lazy { LiveEvent<String>() }

    private val _uiState by lazy { MutableLiveData<UiState>() }
    val uiState: LiveData<UiState> by lazy { _uiState }


    protected fun setIdleState() {
        _uiState.value = UiState.Idle
    }

    protected fun setPendingState() {
        _uiState.value = UiState.Pending
    }

    protected fun showMessage(message: String) {
        _message.value = message
    }

    protected fun handleFailure(throwable: Throwable) {
        errorMapper?.map(throwable)?.let { errorMessage ->
            showMessage(errorMessage)
        }
    }
}