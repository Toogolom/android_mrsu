package com.example.mrsu_finish.data.repository

import com.example.mrsu.domain.models.AccessToken
import com.example.mrsu_finish.data.retrofit.ApiService
import com.example.mrsu_finish.domain.repository.TokenRepository

class TokenRepositoryImpl: TokenRepository {
   override suspend fun getAccessToken(username:String,password:String):AccessToken{
       return ApiService.endpoint_token.getAccessToken("password","8","qweasd",username,password)
    }
}