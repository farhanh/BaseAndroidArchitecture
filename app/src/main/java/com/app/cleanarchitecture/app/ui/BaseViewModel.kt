package com.app.cleanarchitecture.app.ui

import androidx.lifecycle.ViewModel
import com.sampleapp.common.logging.ILogger
import io.reactivex.disposables.CompositeDisposable
import org.koin.core.KoinComponent
import org.koin.core.inject

open class BaseViewModel : ViewModel(), KoinComponent {
    protected val logger: ILogger by inject()

    override fun onCleared() {
        super.onCleared()

    }

}
