package com.example.sopthactaton.presentation.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sopthactaton.data.repoImpl.TestRepo
import com.example.sopthactaton.domain.TestDataSource
import kotlinx.coroutines.launch

class TestViewModel(
    val testRepo: TestRepo
) : ViewModel(){

    fun getUsersContent() =
        viewModelScope.launch {
            val response = testRepo.getUsersRanking()
            if(response.isSuccessful){
                Log.e("log",response.toString())
            }
        }

}