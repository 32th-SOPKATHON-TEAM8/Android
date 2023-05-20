package com.example.sopthactaton.presentation.ranking

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sopthactaton.databinding.ActivityAccuseBinding
import com.example.sopthactaton.databinding.ActivityRankingBinding

class RankingActivity  : AppCompatActivity() {
    private lateinit var binding: ActivityRankingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRankingBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
