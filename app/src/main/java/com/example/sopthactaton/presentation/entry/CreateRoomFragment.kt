package com.example.sopthactaton.presentation.entry

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.sopthactaton.R
import com.example.sopthactaton.databinding.FragmentAnimationBinding
import com.example.sopthactaton.databinding.FragmentCreateRoomBinding
import com.example.sopthactaton.presentation.animation.NoticeViewModel
import com.example.sopthactaton.util.ViewModelFactory

class CreateRoomFragment : Fragment() {
    private val viewModel: RoomViewModel by viewModels { ViewModelFactory(requireContext()) }
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
            setEditTextValidations()
            checkIsValidandFilled()
            // rv로 넘어가는 코드
        }
    }

    private fun setEditTextValidations() {
        with(binding){
            etNickname.doOnTextChanged { text, _, _, _ ->
                viewModel.validateNickName(text.toString())
            }
        }
    }

    private fun checkIsValidandFilled() {
        viewModel.isValidAndFilled.observe(viewLifecycleOwner) { isValidAndFilled ->
            binding.btnEnterRoom.isEnabled = isValidAndFilled
        }
    }
    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}