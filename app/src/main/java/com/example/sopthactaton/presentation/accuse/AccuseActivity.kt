package com.example.sopthactaton.presentation.accuse

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.sopthactaton.R
import com.example.sopthactaton.databinding.ActivityAccuseBinding
import com.example.sopthactaton.presentation.main.MainActivity
import com.example.sopthactaton.util.arePermissionsGranted
import com.example.sopthactaton.util.toast

class AccuseActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAccuseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAccuseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setNavigation()
        binding.chipGroup.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.chip01 -> {
                    startActivity(Intent(this, MainActivity::class.java).apply {
                        addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                    })
                }
                R.id.chip02 -> {
                    selectGallery()
                }
                R.id.chip03 -> {
                    toast("1", Toast.LENGTH_SHORT)
                }
                else -> {
                    toast("2", Toast.LENGTH_SHORT)
                }
            }
        }
    }
    private fun setNavigation() {
        binding.toolbarProductDetail.setNavigationOnClickListener {
            startActivity(Intent(this, MainActivity::class.java).apply {
//                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
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

