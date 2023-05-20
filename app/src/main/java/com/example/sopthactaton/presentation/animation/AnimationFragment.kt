package com.example.sopthactaton.presentation.animation

import android.animation.ObjectAnimator
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateInterpolator
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.sopthactaton.R
import com.example.sopthactaton.databinding.FragmentAnimationBinding
import com.example.sopthactaton.presentation.home.TestViewModel
import com.example.sopthactaton.util.ViewModelFactory
import kotlinx.coroutines.launch

class AnimationFragment : Fragment() {
    private val viewModel: NoticeViewModel by viewModels { ViewModelFactory(requireContext()) }
    private var _binding: FragmentAnimationBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_animation, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        isGotAccusement()
    }


        val imageView = ImageView(requireContext())
        imageView.setImageResource(R.drawable.room_image)

        val parentView =
            view.findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.parentLayout)

        parentView.addView(imageView)

        val initialTranslationY = 900f
        val finalTranslationY = parentView.height.toFloat() - imageView.height

        val animator =
            ObjectAnimator.ofFloat(
                imageView,
                "translationY",
                initialTranslationY,
                finalTranslationY
            )

        imageView.scaleType = ImageView.ScaleType.CENTER

        animator.interpolator = AccelerateInterpolator()

        animator.duration = 2000

        animator.start()


    }

    fun getUsersRanking(){
        viewModel.getUsersContent()
    }
    fun isGotAccusement(){
        // 조건문으로 진실의방 해당자 판별되면 다이얼로그

        getUsersRanking()
        val gotAccusementDialog = GotAccusementDialog()
        gotAccusementDialog.show(parentFragmentManager,"show")
    }



}
