package com.app.cleanarchitecture.di

import android.content.Context
import com.app.cleanarchitecture.api.network.INetworkLayer
import com.app.cleanarchitecture.api.network.NetworkLayer
import com.app.cleanarchitecture.app.ui.note.NoteListViewModel
import com.app.cleanarchitecture.domain.datasource.note.IRemoteNoteDataSource
import com.app.cleanarchitecture.domain.datasource.note.RemoteNoteDataSource
import com.app.cleanarchitecture.domain.repository.note.INoteRepository
import com.app.cleanarchitecture.domain.repository.note.NoteRepository
import com.sampleapp.common.logging.ILogger
import com.sampleapp.common.logging.Logger
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module

/**
 * Defines the Dependency Injection Environment leveraging on the Koin library.
 * Quick Koin reference can be found at https://proandroiddev.com/koin-in-feature-modules-project-6329f069f943
 */
object DependencyInjectionEnvironment {

    private val utilsModule: Module = module {

        single<ILogger> {
            Logger()
        }
    }

    private val networkModule: Module = module {
        single<INetworkLayer> {
            NetworkLayer("google.com")
        }

        single {
            val networkLayer: INetworkLayer = get()
            return@single networkLayer.getNoteService()
        }
    }

    private val noteModule: Module = module {
        single<IRemoteNoteDataSource> {
            RemoteNoteDataSource(networkService = get())
        }

        single<INoteRepository> {
            NoteRepository(remoteNoteSource = get(), logger = get())
        }

        viewModel { NoteListViewModel(noteRepository = get()) }
    }

    private fun getModules(): List<Module> {
        return listOf(utilsModule, networkModule, noteModule)
    }

    fun init(context: Context): KoinApplication {
        return startKoin {
            androidContext(context)
            modules(getModules())
        }
    }
}
