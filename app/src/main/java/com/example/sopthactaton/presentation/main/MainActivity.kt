package com.example.sopthactaton.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sopthactaton.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}

/**
 * activity
 * private val viewModel: TestViewModel by viewModels { ViewModelFactory(this) }
 * fragment
 * private val viewModel: TestViewModel by viewModels { ViewModelFactory(requireContext()) }
 * **/
//1 main 2 fragmentEntry 3.AnimationFragment 4.rankingActivity 5 accuseActivity
