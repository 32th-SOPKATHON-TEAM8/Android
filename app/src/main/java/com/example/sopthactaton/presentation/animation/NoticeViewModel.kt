package com.example.sopthactaton.presentation.animation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sopthactaton.data.repoImpl.TestRepo
import com.example.sopthactaton.domain.TestDataSource
import com.example.sopthactaton.model.ResponseUsersRankingDto
import kotlinx.coroutines.launch

class NoticeViewModel(
    val testRepo: TestRepo
) : ViewModel(){


    fun getUsersContent(){
        viewModelScope.launch {
            val response = testRepo.getUsersRanking()
            if (response.isSuccessful) {
                var userList = response.body()?.data?.user!!
                findHostUser(userList)
            }
        }
    }


    fun findHostUser(users: List<ResponseUsersRankingDto.Data.User>): ResponseUsersRankingDto.Data.User? {
        return users.find { it.isHost }
    }
}