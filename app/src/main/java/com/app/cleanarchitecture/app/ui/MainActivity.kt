package com.app.cleanarchitecture.app.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.app.cleanarchitecture.R
import com.app.cleanarchitecture.app.ui.note.NoteListResult
import com.app.cleanarchitecture.app.ui.note.NoteListViewModel
import com.sampleapp.common.logging.ILogger
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: NoteListViewModel by viewModels()

    @Inject
    lateinit var logger: ILogger

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        logger.i(MainActivity::class.java.simpleName, "HILT_MESSAGE", null)

        viewModel.noteList.observe(this, Observer {
            val result = it ?: return@Observer

            when (result) {
                is NoteListResult.Success -> {

                }

                is NoteListResult.Error -> {

                }
            }
        })
    }
}
