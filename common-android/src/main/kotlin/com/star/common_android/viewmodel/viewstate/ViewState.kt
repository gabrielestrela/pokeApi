package com.star.common_android.viewmodel.viewstate

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class ViewState<VS: State>(initialState: VS) {
    private val _viewState = getInitialState(initialState)
    val viewState: LiveData<VS> = _viewState

    fun setState(suspend: Boolean = false, transform: (VS) -> VS) {
        _viewState.value?.let { vs ->
            if (suspend) _viewState.postValue(transform(vs))
            else _viewState.value = transform(vs)
        }
    }

    private fun <T: State> getInitialState(initialState: T): MutableLiveData<T> =
        MutableLiveData(initialState)
}
