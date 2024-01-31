package com.example.mrsu_finish.domain.usecase

import com.example.mrsu_finish.domain.repository.TokenRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GetAccessToken(private val tokRep: TokenRepository) {
    suspend fun getAccessToken(username: String, password: String): String {
        var accessToken = ""
        CoroutineScope(Dispatchers.IO).launch {
            val token = tokRep.getAccessToken(username, password)
            accessToken = token.access_token
        }.join()
        return accessToken
    }
}
