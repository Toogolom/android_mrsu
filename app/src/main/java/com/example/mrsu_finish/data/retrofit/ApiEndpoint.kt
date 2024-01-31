package com.example.mrsu_finish.data.retrofit


import com.example.mrsu.domain.models.TimeTableToDate
import com.example.mrsu.domain.models.AccessToken
import com.example.mrsu.domain.models.User
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiEndpoint {
    @FormUrlEncoded
    @POST("OAuth/token")
    suspend fun getAccessToken(@Field("grant_type") grantType: String = "password",
                               @Field("client_id") clientId: String= "8",
                               @Field("client_secret") clientSecret: String= "qweasd",
                               @Field("username") username: String,
                               @Field("password") password: String): AccessToken

   @Headers(
       "Content-Type: application/json "
   )
    @GET("v1/User")
    suspend fun getUser(@Header("Authorization") token:String): User

    @GET("v1/StudentTimeTable")
    suspend fun getTimeTable(@Query("date") date:String, @Header("Authorization") token:String): ArrayList<TimeTableToDate>


}

