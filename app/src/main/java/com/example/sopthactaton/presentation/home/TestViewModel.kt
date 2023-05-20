package com.example.sopthactaton.presentation.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sopthactaton.data.repoImpl.TestRepo
import com.example.sopthactaton.domain.TestDataSource
import com.example.sopthactaton.model.ResponseUsersRankingDto
import kotlinx.coroutines.launch

class TestViewModel(
    val testRepo: TestRepo
) : ViewModel(){
    private val _test = MutableLiveData<ResponseUsersRankingDto.Data>()
    val test: LiveData<ResponseUsersRankingDto.Data>
        get() = _test

    fun getUsersContent(){
        viewModelScope.launch {
            val response = testRepo.getUsersRanking()
            if (response.isSuccessful) {
                _test.value= response.body()?.data
            }
        }
    }
}