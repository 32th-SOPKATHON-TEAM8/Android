package com.example.sopthactaton.api.repo

import retrofit2.Response

class TestRepo(
    private val testDataSource: TestRepoRemoteDataSource
){
    suspend fun getMainPage():Response<Any> {
        return testDataSource.getMainPage()
    }
}