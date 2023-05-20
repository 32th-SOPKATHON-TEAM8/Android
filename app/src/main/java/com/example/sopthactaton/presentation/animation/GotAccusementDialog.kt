package com.example.sopthactaton.presentation.animation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.sopthactaton.databinding.DialogNotifyGotAccusementBinding

class GotAccusementDialog : DialogFragment() {
    private var _binding: DialogNotifyGotAccusementBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DialogNotifyGotAccusementBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBtn()
    }

    fun initBtn(){
        binding.btnDialogAccept.setOnClickListener {
            dismiss()
        }
    }
}