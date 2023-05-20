package com.example.sopthactaton.api

import retrofit2.Response
import retrofit2.http.GET

interface TestApiService  {
    @GET("test")
    suspend fun getMainPage():Response<Any>
}