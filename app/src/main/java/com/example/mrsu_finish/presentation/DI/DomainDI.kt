package com.example.mrsu_finish.presentation.DI

import com.example.mrsu_finish.domain.usecase.GetAccessToken
import com.example.mrsu_finish.domain.usecase.GetShedule
import com.example.mrsu_finish.domain.usecase.GetUser
import org.koin.dsl.module


val domainModule = module {

    factory <GetAccessToken>{
        GetAccessToken(tokRep = get())
    }

    factory <GetUser>{
        GetUser(userRep = get())
    }
    factory <GetShedule> {
        GetShedule(sheduleRep = get())
    }


}