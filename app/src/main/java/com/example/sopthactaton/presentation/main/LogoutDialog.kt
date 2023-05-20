package com.example.sopthactaton.presentation.main

//import android.content.Intent
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.fragment.app.DialogFragment
//import com.example.sopthactaton.databinding.DialogAlertBinding
//
//class LogoutDialog() : DialogFragment() {
//    private var _binding: DialogAlertBinding? = null
//    private val binding get() = _binding!!
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        _binding = DialogAlertBinding.inflate(inflater, container, false)
//        return binding.root
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        initBtn()
//    }
//
//    private fun initBtn() {
//        binding.btnOk.setOnClickListener {
//            startMainActivity()
//        }
//        binding.btnFail.setOnClickListener {
//            dismiss()
//        }
//    }
//
//    private fun startMainActivity() {
//        Intent(activity, MainActivity::class.java).apply {
//            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
//            startActivity(this)
//        }
//    }
//
//    override fun onDestroy() {
//        _binding = null
//        super.onDestroy()
//
//    }
//}