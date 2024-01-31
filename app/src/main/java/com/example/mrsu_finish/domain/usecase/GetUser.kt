package com.example.mrsu_finish.domain.usecase

import com.example.mrsu.domain.models.User
import com.example.mrsu_finish.domain.repository.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class GetUser(private val userRep: UserRepository) {

    private var cachedUserData: User? = null

    private suspend fun getUserData(token: String): User {
        return cachedUserData ?: withContext(Dispatchers.IO) {
            val user = userRep.getUser(token)
            cachedUserData = user
            user
        }
    }

    suspend fun getUserLastName(token: String): String {
        val user = getUserData(token)
        val fullName = user.FIO
        val parts = fullName.split(" ")

        return parts[0]
    }

    suspend fun getUserName(token: String): String {
        val user = getUserData(token)
        val fullName = user.FIO
        val parts = fullName.split(" ")

        return parts[1] +" "+ parts[2]

    }
    suspend fun getUserId(token:String):String{
        val user = getUserData(token)
        return "id: " + user.StudentCod
    }
}
