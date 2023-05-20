package com.example.sopthactaton.presentation.entry

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.sopthactaton.R
import com.example.sopthactaton.databinding.FragmentEntryBinding
import com.example.sopthactaton.presentation.animation.AnimationFragment

class EntryFragment : Fragment() {
    private var _binding: FragmentEntryBinding? = null
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
        toAnimation()
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
    fun toAnimation(){
        binding.ibnInRoom.setOnClickListener {
            // 두 번째 Fragment로 전환
            val secondFragment = CreateRoomFragment()
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, secondFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }

    }

}
