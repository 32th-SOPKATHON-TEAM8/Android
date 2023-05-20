package com.example.sopthactaton.presentation.accuse

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.graphics.Typeface
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.isGone
import com.bumptech.glide.Glide
import com.example.sopthactaton.R
import com.example.sopthactaton.databinding.ActivityAccuseBinding
import com.example.sopthactaton.presentation.ranking.RankingActivity
import com.example.sopthactaton.util.ViewModelFactory
import com.example.sopthactaton.util.arePermissionsGranted

class AccuseActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAccuseBinding
    private val viewModel: AccuseViewModel by viewModels { ViewModelFactory(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAccuseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setNavigation()
        viewModel.getMainPage()
        viewModel.chip.observe(this){
            binding.chip01.text = it[0].name
            binding.chip02.text = it[1].name
            binding.chip03.text = it[2].name
            binding.chip04.text = it[3].name
            binding.chip05.text = it[4].name
            binding.chip06.text = it[5].name
            binding.chip07.text = it[6].name
        }


        binding.ivTest.setOnClickListener {
            selectGallery()
            binding.ivTest2.visibility = View.INVISIBLE
        }
        binding.btnAccuse.setOnClickListener {
            viewModel.accuse(2)
            startActivity(Intent(this, RankingActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            })
        }
        binding.chipGroup.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.chip01 -> {
                    binding.chip01.setChipBackgroundColorResource(R.color.colorPrimary)
                    binding.chip01.setTypeface(null, Typeface.BOLD)
                    binding.chip02.setChipBackgroundColorResource(R.color.gray_200)
                    binding.chip02.setTextColor(ContextCompat.getColor(this, R.color.gray_400))
                    binding.chip03.setChipBackgroundColorResource(R.color.gray_200)
                    binding.chip03.setTextColor(ContextCompat.getColor(this, R.color.gray_400))
                    binding.chip04.setChipBackgroundColorResource(R.color.gray_200)
                    binding.chip04.setTextColor(ContextCompat.getColor(this, R.color.gray_400))
                    binding.chip05.setChipBackgroundColorResource(R.color.gray_200)
                    binding.chip05.setTextColor(ContextCompat.getColor(this, R.color.gray_400))
                    binding.chip06.setChipBackgroundColorResource(R.color.gray_200)
                    binding.chip06.setTextColor(ContextCompat.getColor(this, R.color.gray_400))
                    binding.chip07.setChipBackgroundColorResource(R.color.gray_200)
                    binding.chip07.setTextColor(ContextCompat.getColor(this, R.color.gray_400))

                }
                R.id.chip02 -> {
                    binding.chip02.setChipBackgroundColorResource(R.color.colorPrimary)
                    binding.chip02.setTypeface(null, Typeface.BOLD)
                    binding.chip01.setChipBackgroundColorResource(R.color.gray_200)
                    binding.chip01.setTextColor(ContextCompat.getColor(this, R.color.gray_400))
                    binding.chip03.setChipBackgroundColorResource(R.color.gray_200)
                    binding.chip03.setTextColor(ContextCompat.getColor(this, R.color.gray_400))
                    binding.chip04.setChipBackgroundColorResource(R.color.gray_200)
                    binding.chip04.setTextColor(ContextCompat.getColor(this, R.color.gray_400))
                    binding.chip05.setChipBackgroundColorResource(R.color.gray_200)
                    binding.chip05.setTextColor(ContextCompat.getColor(this, R.color.gray_400))
                    binding.chip06.setChipBackgroundColorResource(R.color.gray_200)
                    binding.chip06.setTextColor(ContextCompat.getColor(this, R.color.gray_400))
                    binding.chip07.setChipBackgroundColorResource(R.color.gray_200)
                    binding.chip07.setTextColor(ContextCompat.getColor(this, R.color.gray_400))
                }
                R.id.chip03 -> {
                    binding.chip03.setChipBackgroundColorResource(R.color.colorPrimary)
                    binding.chip03.setTypeface(null, Typeface.BOLD)
                    binding.chip02.setChipBackgroundColorResource(R.color.gray_200)
                    binding.chip02.setTextColor(ContextCompat.getColor(this, R.color.gray_400))
                    binding.chip01.setChipBackgroundColorResource(R.color.gray_200)
                    binding.chip01.setTextColor(ContextCompat.getColor(this, R.color.gray_400))
                    binding.chip04.setChipBackgroundColorResource(R.color.gray_200)
                    binding.chip04.setTextColor(ContextCompat.getColor(this, R.color.gray_400))
                    binding.chip05.setChipBackgroundColorResource(R.color.gray_200)
                    binding.chip05.setTextColor(ContextCompat.getColor(this, R.color.gray_400))
                    binding.chip06.setChipBackgroundColorResource(R.color.gray_200)
                    binding.chip06.setTextColor(ContextCompat.getColor(this, R.color.gray_400))
                    binding.chip07.setChipBackgroundColorResource(R.color.gray_200)
                    binding.chip07.setTextColor(ContextCompat.getColor(this, R.color.gray_400))
                }
                R.id.chip04 -> {
                    binding.chip04.setChipBackgroundColorResource(R.color.colorPrimary)
                    binding.chip04.setTypeface(null, Typeface.BOLD)
                    binding.chip02.setChipBackgroundColorResource(R.color.gray_200)
                    binding.chip02.setTextColor(ContextCompat.getColor(this, R.color.gray_400))
                    binding.chip03.setChipBackgroundColorResource(R.color.gray_200)
                    binding.chip03.setTextColor(ContextCompat.getColor(this, R.color.gray_400))
                    binding.chip01.setChipBackgroundColorResource(R.color.gray_200)
                    binding.chip01.setTextColor(ContextCompat.getColor(this, R.color.gray_400))
                    binding.chip05.setChipBackgroundColorResource(R.color.gray_200)
                    binding.chip05.setTextColor(ContextCompat.getColor(this, R.color.gray_400))
                    binding.chip06.setChipBackgroundColorResource(R.color.gray_200)
                    binding.chip06.setTextColor(ContextCompat.getColor(this, R.color.gray_400))
                    binding.chip07.setChipBackgroundColorResource(R.color.gray_200)
                    binding.chip07.setTextColor(ContextCompat.getColor(this, R.color.gray_400))
                }
                R.id.chip05 -> {
                    binding.chip05.setChipBackgroundColorResource(R.color.colorPrimary)
                    binding.chip05.setTypeface(null, Typeface.BOLD)
                    binding.chip02.setChipBackgroundColorResource(R.color.gray_200)
                    binding.chip02.setTextColor(ContextCompat.getColor(this, R.color.gray_400))
                    binding.chip03.setChipBackgroundColorResource(R.color.gray_200)
                    binding.chip03.setTextColor(ContextCompat.getColor(this, R.color.gray_400))
                    binding.chip04.setChipBackgroundColorResource(R.color.gray_200)
                    binding.chip04.setTextColor(ContextCompat.getColor(this, R.color.gray_400))
                    binding.chip01.setChipBackgroundColorResource(R.color.gray_200)
                    binding.chip01.setTextColor(ContextCompat.getColor(this, R.color.gray_400))
                    binding.chip06.setChipBackgroundColorResource(R.color.gray_200)
                    binding.chip06.setTextColor(ContextCompat.getColor(this, R.color.gray_400))
                    binding.chip07.setChipBackgroundColorResource(R.color.gray_200)
                    binding.chip07.setTextColor(ContextCompat.getColor(this, R.color.gray_400))
                }
                R.id.chip06 -> {
                    binding.chip06.setChipBackgroundColorResource(R.color.colorPrimary)
                    binding.chip06.setTypeface(null, Typeface.BOLD)
                    binding.chip02.setChipBackgroundColorResource(R.color.gray_200)
                    binding.chip02.setTextColor(ContextCompat.getColor(this, R.color.gray_400))
                    binding.chip03.setChipBackgroundColorResource(R.color.gray_200)
                    binding.chip03.setTextColor(ContextCompat.getColor(this, R.color.gray_400))
                    binding.chip04.setChipBackgroundColorResource(R.color.gray_200)
                    binding.chip04.setTextColor(ContextCompat.getColor(this, R.color.gray_400))
                    binding.chip05.setChipBackgroundColorResource(R.color.gray_200)
                    binding.chip05.setTextColor(ContextCompat.getColor(this, R.color.gray_400))
                    binding.chip01.setChipBackgroundColorResource(R.color.gray_200)
                    binding.chip01.setTextColor(ContextCompat.getColor(this, R.color.gray_400))
                    binding.chip07.setChipBackgroundColorResource(R.color.gray_200)
                    binding.chip07.setTextColor(ContextCompat.getColor(this, R.color.gray_400))
                }
                R.id.chip07 -> {
                    binding.chip07.setChipBackgroundColorResource(R.color.colorPrimary)
                    binding.chip07.setTypeface(null, Typeface.BOLD)
                    binding.chip02.setChipBackgroundColorResource(R.color.gray_200)
                    binding.chip02.setTextColor(ContextCompat.getColor(this, R.color.gray_400))
                    binding.chip03.setChipBackgroundColorResource(R.color.gray_200)
                    binding.chip03.setTextColor(ContextCompat.getColor(this, R.color.gray_400))
                    binding.chip04.setChipBackgroundColorResource(R.color.gray_200)
                    binding.chip04.setTextColor(ContextCompat.getColor(this, R.color.gray_400))
                    binding.chip05.setChipBackgroundColorResource(R.color.gray_200)
                    binding.chip05.setTextColor(ContextCompat.getColor(this, R.color.gray_400))
                    binding.chip06.setChipBackgroundColorResource(R.color.gray_200)
                    binding.chip06.setTextColor(ContextCompat.getColor(this, R.color.gray_400))
                    binding.chip01.setChipBackgroundColorResource(R.color.gray_200)
                    binding.chip01.setTextColor(ContextCompat.getColor(this, R.color.gray_400))
                }
                else -> {
                }
            }
        }
    }
    private fun setNavigation() {
        binding.toolbarProductDetail.setNavigationOnClickListener {
            startActivity(Intent(this, RankingActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            })
        }
    }
    private fun selectGallery() {
        val permissions = arrayOf(
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE
        )
        if (arePermissionsGranted(permissions, this)) openGallery()
        else ActivityCompat.requestPermissions(this, permissions, 1)
    }

    private fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            .apply {
                type = "image/*"
                putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
            }
        imageResult.launch(intent)
    }

    private val imageResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data: Intent? = result.data
            val imageUri: Uri? = data?.data
            imageUri?.let {
                Glide.with(this)
                    .load(it)
                    .override(500, 500)
                    .into(binding.ivTest)
            }
        }
    }
}

