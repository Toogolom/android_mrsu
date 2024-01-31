package com.example.mrsu_finish.presentation.ViewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mrsu.domain.models.TimeTableToDate
import com.example.mrsu_finish.domain.usecase.GetAccessToken
import com.example.mrsu_finish.domain.usecase.GetShedule
import com.example.mrsu_finish.domain.usecase.GetUser
import kotlinx.coroutines.launch
import retrofit2.HttpException

class MainViewModel(
    private val getAccessToken: GetAccessToken,
    private val getUser: GetUser,
    private val getShedule:GetShedule
) : ViewModel() {

    init {
        Log.d("MainViewModel", "ViewModel created")
    }

    override fun onCleared() {
        Log.d("MainViewModel", "ViewModel cleared")
        super.onCleared()
    }

    val token = MutableLiveData<String>()

    val error = MutableLiveData<String>()

    val lastName = MutableLiveData<String>()

    val id = MutableLiveData<String>()

    val name = MutableLiveData<String>()

    val shedule = MutableLiveData<ArrayList<TimeTableToDate>>()

    val groupInfo = MutableLiveData<Pair<String,String>>()


    fun login(username: String, password: String) {
        viewModelScope.launch {
            try {
                token.value = getAccessToken.getAccessToken(username, password)
            } catch (e: HttpException) {
                error.postValue(when (e.code()) {
                    400 -> "Неправильный логин или пароль"
                    else -> "Ошибка сервера"
                })
            } catch (e: Exception) {
                error.postValue("Ошибка")
            }
        }
    }

    fun getUserLastName() {
        viewModelScope.launch {
            try {
                val result = getUser.getUserLastName("Bearer " + token.value)
                lastName.postValue(result)
            } catch (e: Exception) {
                error.postValue("Ошибка")
            }
        }
    }
    fun getUserName() {
        viewModelScope.launch {
            try {
                val result = getUser.getUserName("Bearer " + token.value)
                name.postValue(result)
            } catch (e: Exception) {
                error.postValue("Ошибка")
            }
        }
    }
    fun getUserId() {
        viewModelScope.launch {
            try {
                val result = getUser.getUserId("Bearer " + token.value)
                id.postValue(result)
            } catch (e: Exception) {
                error.postValue("Ошибка")
            }
        }
    }
    fun getShedule(date:String) {
        viewModelScope.launch {
            try {
                val result = getShedule.getSheduleData(date, "Bearer " + token.value)
                shedule.postValue(result)
            } catch (e: Exception) {
                error.postValue("Ошибка")
            }
        }
    }
    fun getGroupInfo(date:String) {
        viewModelScope.launch {
            try {
                var result1 = getShedule.getGroupInfo(date, "Bearer " + token.value,0)
                val result2 = getShedule.getGroupInfo(date, "Bearer " + token.value,1)
                val resultPair = Pair(result1, result2)

                groupInfo.postValue(resultPair)
            } catch (e: Exception) {
                error.postValue("Ошибка")
            }
        }
    }

}



