package com.example.mrsu_finish.domain.repository

import com.example.mrsu.domain.models.AccessToken

interface TokenRepository {
    suspend fun getAccessToken(username: String, password: String): AccessToken
}