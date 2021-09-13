package com.app.cleanarchitecture.app.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.app.cleanarchitecture.R
import com.app.cleanarchitecture.app.ui.note.NoteEvents
import com.app.cleanarchitecture.app.ui.note.NoteListViewModel
import com.app.cleanarchitecture.common.logging.ILogger
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject
import com.app.cleanarchitecture.domain.datasource.ResultState

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: NoteListViewModel by viewModels()

    @Inject
    lateinit var logger: ILogger

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        logger.i(MainActivity::class.java.simpleName, "HILT_MESSAGE", null)

        viewModel.onStartEvent(NoteEvents.GetNoteList)
        initObservers()
    }

    private fun initObservers() {
        viewModel.noteListLiveData.observe(this, Observer {
            val state = it ?: return@Observer

            when (state) {
                is ResultState.Success -> {
                    Timber.i("Success: ${state.data}")
                    Timber.i("hide progress bar")
                }

                is ResultState.Error -> {
                    Timber.i("Error: ${state.exception}")
                    Timber.i("hide progress bar")
                }

                is ResultState.Loading -> {
                    Timber.i("show progress bar")
                }
            }
        })
    }
}
