package com.example.sopthactaton.presentation.animation

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateInterpolator
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.sopthactaton.R
import com.example.sopthactaton.databinding.FragmentAnimationBinding

class AnimationFragment : Fragment() {

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




}
