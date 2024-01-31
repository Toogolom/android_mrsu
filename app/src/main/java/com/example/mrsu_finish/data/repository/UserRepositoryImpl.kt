package com.example.mrsu_finish.data.repository


import com.example.mrsu.domain.models.User
import com.example.mrsu_finish.data.retrofit.ApiService
import com.example.mrsu_finish.domain.repository.UserRepository

class UserRepositoryImpl : UserRepository {
    override suspend fun getUser(token:String): User {
        return ApiService.endpoint.getUser(token)
    }
}