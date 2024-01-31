package com.example.mrsu_finish.presentation.DI


import com.example.mrsu_finish.presentation.ViewModels.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single {
        MainViewModel(
            getAccessToken = get(),
            getUser = get(),
            getShedule = get()
        )
    }
}
