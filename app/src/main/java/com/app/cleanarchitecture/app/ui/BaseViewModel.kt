package com.app.cleanarchitecture.app.ui

import androidx.lifecycle.ViewModel

open class BaseViewModel() : ViewModel() {

    override fun onCleared() {
        super.onCleared()

    }

}
