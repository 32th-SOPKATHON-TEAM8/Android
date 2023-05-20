package com.example.sopthactaton.presentation.animation

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sopthactaton.data.repoImpl.TestRepo
import com.example.sopthactaton.domain.TestDataSource
import com.example.sopthactaton.model.ResponseUsersRankingDto
import kotlinx.coroutines.launch

class NoticeViewModel(
    val testRepo: TestRepo
) : ViewModel(){
    private var _hostLiveData = MutableLiveData<List<ResponseUsersRankingDto.Data.User>>()
    val hostLiveData: List<ResponseUsersRankingDto.Data.User>?
        get() = _hostLiveData.value



    fun getUsersContent(){
        viewModelScope.launch {
            val response = testRepo.getUsersRanking()
            if (response.isSuccessful) {
                var userList = response.body()?.data?.user!!
                _hostLiveData.value = findHostUsers(userList)
            }
        }
    }

    fun findHostUsers(users: List<ResponseUsersRankingDto.Data.User>): List<ResponseUsersRankingDto.Data.User> {
        return users.filter { it.isHost }
    }
}