package com.example.mrsu_finish.domain.usecase

import com.example.mrsu.domain.models.TimeTableToDate
import com.example.mrsu.domain.models.User
import com.example.mrsu_finish.domain.repository.SheduleRepository
import com.example.mrsu_finish.domain.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetShedule(private val sheduleRep: SheduleRepository) {

    suspend fun getSheduleData(date: String, token: String): ArrayList<TimeTableToDate> {
        return sheduleRep.getShedule(date, token)
    }

    suspend fun getGroupInfo(date: String, token: String, pos: Int): String {
        val shedule = getSheduleData(date, token)
        return shedule.get(pos).FacultyName + "(${shedule.get(pos).Group})"
    }
}