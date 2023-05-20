package com.example.sopthactaton.presentation.main

import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.viewModelScope
import com.example.sopthactaton.R
import com.example.sopthactaton.databinding.ActivityMainBinding
import com.example.sopthactaton.domain.TestDataSource
import com.example.sopthactaton.presentation.animation.AnimationFragment
import com.example.sopthactaton.presentation.entry.EntryFragment
import com.example.sopthactaton.presentation.home.TestViewModel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val viewModel by viewModels<TestViewModel>()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        toEntry()

    }

    fun toEntry(){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val fragment = EntryFragment()
        fragmentTransaction.add(R.id.fragment_container, fragment)
        fragmentTransaction.commit()
    }
    fun toAnimation(){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val fragment = AnimationFragment()
        fragmentTransaction.add(R.id.fragment_container, fragment)
        fragmentTransaction.commit()

    }

}

/**
 * activity
 * private val viewModel: TestViewModel by viewModels { ViewModelFactory(this) }
 * fragment
 * private val viewModel: TestViewModel by viewModels { ViewModelFactory(requireContext()) }
 * **/
//1 main 2 fragmentEntry 3.AnimationFragment 4.rankingActivity 5 accuseActivity
