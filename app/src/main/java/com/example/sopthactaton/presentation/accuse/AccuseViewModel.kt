package com.example.sopthactaton.presentation.accuse

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sopthactaton.data.repoImpl.AccuseRepoImpl
import com.example.sopthactaton.data.repoImpl.TestRepo
import com.example.sopthactaton.model.Category
import com.example.sopthactaton.model.userId
import kotlinx.coroutines.launch

class AccuseViewModel  (
private val accuseRepoImpl: AccuseRepoImpl
) : ViewModel(){
    private val _chip = MutableLiveData<List<Category>>()
    val chip: LiveData<List<Category>>
        get() = _chip
    fun getMainPage() = viewModelScope.launch {
        val response = accuseRepoImpl.getCategory()
        if(response.isSuccessful){
            _chip.value=response.body()?.data?.categories
        }
    }

    fun accuse(userId1:Int) = viewModelScope.launch {
        val response = accuseRepoImpl.accuse(userId1)
        if(response.isSuccessful){
            Log.d("test","test")
        }
    }
}