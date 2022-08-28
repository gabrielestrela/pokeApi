package com.star.common_android.viewmodel.sideeffect

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.star.common_android.livedata.SingleLiveEvent

class ViewSideEffect<SE: SideEffect> {

    private val _viewSideEffect: SingleLiveEvent<SE> = getSideEffect()
    val viewSideEffect: SingleLiveEvent<SE> = _viewSideEffect

    fun setSideEffect(sideEffect: () -> SE, suspend: Boolean = false) {
        if (suspend) _viewSideEffect.postValue(sideEffect())
        else _viewSideEffect.value = sideEffect()
    }

    private fun <T: SideEffect> getSideEffect() = SingleLiveEvent<T>()
}