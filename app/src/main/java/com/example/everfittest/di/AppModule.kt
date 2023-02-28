package com.example.everfittest.di

import com.example.everfittest.data.repository.AssignmentRepository
import com.example.everfittest.data.repository.AssignmentRepositoryImp
import com.example.everfittest.ui.MainViewModel

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {
    /*viewModel {
        MainViewModel(get())
    }*/
}

val repositoryModule = module {
    //single<AssignmentRepository> { AssignmentRepositoryImp(get()) }
}

fun provideGson(): Gson? {
    val gsonBuilder = GsonBuilder()
    return gsonBuilder.create()
}