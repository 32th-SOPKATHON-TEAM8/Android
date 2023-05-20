package com.example.sopthactaton.presentation.entry

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.sopthactaton.R
import com.example.sopthactaton.databinding.FragmentAnimationBinding
import com.example.sopthactaton.databinding.FragmentCreateRoomBinding
import com.example.sopthactaton.presentation.animation.NoticeViewModel
import com.example.sopthactaton.presentation.main.MainActivity
import com.example.sopthactaton.presentation.ranking.RankingActivity
import com.example.sopthactaton.util.ViewModelFactory

class CreateRoomFragment : Fragment() {
    private var _binding: FragmentCreateRoomBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_entry, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnEnterRoom.setOnClickListener{
            startActivity(Intent(context, RankingActivity::class.java))
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}