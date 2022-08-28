package com.star.common_android.livedata

import androidx.annotation.MainThread
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import timber.log.Timber
import java.util.concurrent.atomic.AtomicBoolean

open class SingleLiveEvent<T> : MutableLiveData<T>() {
    private val pending = AtomicBoolean(false)

    @MainThread
    override fun observe(
        owner: LifecycleOwner,
        observer: Observer<in T>
    ) {
        if (hasActiveObservers()) Timber.w(OBSERVER_WARNING)

        super.observe(owner) {
            if (pending.compareAndSet(true, false)) {
                observer.onChanged(it)
            }
        }
    }

    @MainThread
    override fun setValue(value: T?) {
        pending.set(true)
        super.setValue(value)
    }

    @MainThread
    fun call() { value = null }

    companion object {
        private const val OBSERVER_WARNING =
            "Multiple observers registered but only one will be notified of changes."
    }
}
