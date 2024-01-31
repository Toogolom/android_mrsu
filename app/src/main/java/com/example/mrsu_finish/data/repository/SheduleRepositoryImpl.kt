package com.example.mrsu_finish.data.repository

import com.example.mrsu.domain.models.TimeTableToDate
import com.example.mrsu_finish.data.retrofit.ApiService
import com.example.mrsu_finish.domain.repository.SheduleRepository

class SheduleRepositoryImpl: SheduleRepository {
    override suspend fun getShedule(date:String,token:String): ArrayList<TimeTableToDate> {
        return ApiService.endpoint.getTimeTable(date,token)
    }
}