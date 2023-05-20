package com.example.sopthactaton.presentation.entry

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.sopthactaton.R
import com.example.sopthactaton.databinding.FragmentCreateRoomBinding
import com.example.sopthactaton.presentation.ranking.RankingActivity

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