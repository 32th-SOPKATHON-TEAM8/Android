package com.example.sopthactaton.presentation.animation

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateInterpolator
import android.widget.ImageView
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
    ): View {
        _binding = FragmentAnimationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageView = ImageView(requireContext())
        imageView.setImageResource(R.drawable.ic_launcher_background)

        val parentView = binding.parentLayout
        parentView.addView(imageView)

        val animator = ObjectAnimator.ofFloat(imageView, "translationY", 1500f, parentView.height.toFloat())

        animator.interpolator = AccelerateInterpolator()
        animator.duration = 1000

        animator.start()
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}
