package com.bashirli.techtask.common.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bashirli.techtask.common.Resource
import kotlinx.coroutines.launch

abstract class BaseViewModel<STATE : State, EFFECT : Effect> : ViewModel() {

    private val _liveData: MutableLiveData<STATE> = MutableLiveData<STATE>()
    val liveData: LiveData<STATE> get() = _liveData


    private val _effect: MutableLiveData<EFFECT> = MutableLiveData<EFFECT>()
    val effect: LiveData<EFFECT> get() = _effect

    fun setEffect(effect: EFFECT) {
        viewModelScope.launch {
            _effect.value = effect
        }
    }

    inline fun <T> Resource<T>.handleResult(
        crossinline onComplete: (T) -> Unit,
        crossinline onError: (Throwable) -> Unit,
    ) {
        when (this) {
            is Resource.Error -> {
                onError(throwable)
            }

            is Resource.Success -> {
                result?.let { onComplete(result) }
            }

        }
    }

    fun setState(state: STATE) {
        viewModelScope.launch {
            _liveData.value = state
        }
    }


}

interface State
interface Effect