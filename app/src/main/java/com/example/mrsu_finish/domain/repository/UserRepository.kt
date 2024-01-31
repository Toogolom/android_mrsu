package com.example.mrsu_finish.domain.repository

import com.example.mrsu.domain.models.User

interface UserRepository {
    suspend fun getUser(token:String): User
}