package com.star.common_android.viewmodel

import androidx.lifecycle.LiveData
import com.star.common_android.livedata.SingleLiveEvent
import com.star.common_android.viewmodel.sideeffect.SideEffect
import com.star.common_android.viewmodel.sideeffect.ViewSideEffect
import com.star.common_android.viewmodel.viewprocedure.ViewProcedure
import com.star.common_android.viewmodel.viewstate.State
import com.star.common_android.viewmodel.viewstate.ViewState

abstract class ViewModel<VS: State, VP: ViewProcedure, SE: SideEffect>(
    initialState: VS
) : androidx.lifecycle.ViewModel() {

    private val _viewState = ViewState(initialState)
    val viewState: LiveData<VS> = _viewState.viewState

    private val _sideEffect = ViewSideEffect<SE>()
    val sideEffect: SingleLiveEvent<SE> = _sideEffect.viewSideEffect

    protected fun setState(
        suspend: Boolean = false,
        transform: (VS) -> VS
    ) {
        _viewState.setState(transform = transform, suspend = suspend)
    }

    protected fun setSideEffect(
        suspend: Boolean = false,
        sideEffect: () -> SE
    ) {
        _sideEffect.setSideEffect(sideEffect = sideEffect, suspend = suspend)
    }

    abstract fun executeViewProcedure(procedure: VP)
}