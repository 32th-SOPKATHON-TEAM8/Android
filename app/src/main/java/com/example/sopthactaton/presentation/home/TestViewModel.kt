package com.example.sopthactaton.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sopthactaton.data.repoImpl.TestRepo
import kotlinx.coroutines.launch

class TestViewModel(
    val testRepo: TestRepo
) : ViewModel(){

    fun getMainPage() = viewModelScope.launch {
        val response = testRepo.getMainPage()
        if(response.isSuccessful){
        }
    }

}