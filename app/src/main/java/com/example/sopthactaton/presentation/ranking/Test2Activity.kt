package com.example.sopthactaton.presentation.ranking

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sopthactaton.api.model.ResponseRankingDto
import com.example.sopthactaton.databinding.ActivityTestBinding

class Test2Activity: AppCompatActivity() {
    private lateinit var binding: ActivityTestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var data = intent.getStringExtra("data")

        binding.tvNickname.text = data

    }
}