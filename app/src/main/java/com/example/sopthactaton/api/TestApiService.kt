package com.example.sopthactaton.api

import com.example.sopthactaton.model.ResponseUsersRankingDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TestApiService  {
    @GET("/group/{groupId}")
    suspend fun getUsersRanking(
        @Path("groupId") groupId:Long,
    ):Response<ResponseUsersRankingDto>
}