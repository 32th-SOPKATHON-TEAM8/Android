package com.example.sopthactaton.presentation.accuse

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sopthactaton.R
import com.example.sopthactaton.databinding.ActivityAccuseBinding

class AccuseActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAccuseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAccuseBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
