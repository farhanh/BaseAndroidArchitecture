package com.app.cleanarchitecture.app.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.app.cleanarchitecture.R
import com.app.cleanarchitecture.app.ui.note.NoteListResult
import com.app.cleanarchitecture.app.ui.note.NoteListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: NoteListViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.noteList.observe(this, Observer {
            val result = it ?: return@Observer

            when(result){
                is NoteListResult.Success -> {

                }

                is NoteListResult.Error -> {

                }
            }
        })
    }
}
