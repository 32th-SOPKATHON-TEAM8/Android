package com.example.sopthactaton.data.repoImpl

import com.example.sopthactaton.data.datasource.TestRepoRemoteDataSource
import com.example.sopthactaton.model.ResponseUsersRankingDto
import retrofit2.Response

class TestRepo(
    private val testDataSource: TestRepoRemoteDataSource
){
    suspend fun getUsersRanking():Response<ResponseUsersRankingDto> {
        return testDataSource.getUsersRanking()
    }
}