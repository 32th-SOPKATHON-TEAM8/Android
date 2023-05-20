package com.example.sopthactaton.domain

import com.example.sopthactaton.model.ResponseUsersRankingDto
import retrofit2.Response
/**
 * flow interface -> RemoteDataSource -> Repository -> ViewModel (ViewModelFactory 등록 해야댐)
 *
 *
 * **/

interface TestDataSource  {
    suspend fun getUsersRanking(): Response<ResponseUsersRankingDto>
}

