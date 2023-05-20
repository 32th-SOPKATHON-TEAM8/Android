package com.example.sopthactaton.api.repo

import retrofit2.Response
/**
 * flow interface -> RemoteDataSource -> Repository -> ViewModel (ViewModelFactory 등록 해야댐)
 *
 *
 * **/

interface TestDataSource  {
    suspend fun getMainPage(): Response<Any>
}

