package com.example.mrsu_finish.domain.repository

import com.example.mrsu.domain.models.TimeTableToDate
import com.example.mrsu_finish.data.repository.SheduleRepositoryImpl

interface SheduleRepository{
    suspend fun getShedule(date:String,token:String): ArrayList<TimeTableToDate>
}