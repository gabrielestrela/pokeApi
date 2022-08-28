package com.star.common_android.livedata

import androidx.lifecycle.MutableLiveData

class DistinctLiveData<T> : MutableLiveData<T>() {
    private var cache: T? = null

    @Synchronized
    override fun setValue(value: T?) {
        if (value != cache || this.value != cache) {
            cache = value
            super.setValue(value)
        }
    }

    @Synchronized
    override fun postValue(value: T) {
        if (value != cache || this.value != cache) {
            cache = value
            this.postValue(value)
        }
    }
}
