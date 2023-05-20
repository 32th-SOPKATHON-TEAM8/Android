package com.example.sopthactaton.util

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.sopthactaton.api.ServicePool
import com.example.sopthactaton.data.repoImpl.TestRepo
import com.example.sopthactaton.data.datasource.TestRepoRemoteDataSource
import com.example.sopthactaton.presentation.home.TestViewModel


class ViewModelFactory(private val context: Context) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(TestViewModel::class.java) -> {
                val repository = TestRepo(TestRepoRemoteDataSource(ServicePool.testService))
                TestViewModel(repository) as T
            }

            else -> {
                throw IllegalArgumentException("Failed to create ViewModel : ${modelClass.name}")
            }
        }
    }
}