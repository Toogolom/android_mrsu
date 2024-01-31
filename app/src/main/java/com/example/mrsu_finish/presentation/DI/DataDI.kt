package com.example.mrsu_finish.presentation.DI

import com.example.mrsu_finish.data.repository.SheduleRepositoryImpl
import com.example.mrsu_finish.data.repository.TokenRepositoryImpl
import com.example.mrsu_finish.data.repository.UserRepositoryImpl
import com.example.mrsu_finish.domain.repository.SheduleRepository
import com.example.mrsu_finish.domain.repository.TokenRepository
import com.example.mrsu_finish.domain.repository.UserRepository
import org.koin.dsl.module


val dataModule = module {

    single<TokenRepository>{
        TokenRepositoryImpl()
    }

    single<UserRepository>{
        UserRepositoryImpl()
    }
    single<SheduleRepository>{
        SheduleRepositoryImpl()
    }

}