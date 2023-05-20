package com.example.sopthactaton.presentation.animation



import android.animation.ObjectAnimator
import android.os.Bundle

import android.view.animation.AccelerateInterpolator
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.sopthactaton.R

class AnimationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_animation)

        val imageView = ImageView(this)
        imageView.setImageResource(R.drawable.room_image)

        val parentView =
            findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.parentLayout)

        parentView.addView(imageView)
        val initialTranslationY = 1400f
        val finalTranslationY = parentView.height.toFloat() - imageView.height

        val animator =
            ObjectAnimator.ofFloat(
                imageView,
                "translationY",
                900f,
                initialTranslationY,
                finalTranslationY
            )

        imageView.scaleType = ImageView.ScaleType.CENTER

        animator.interpolator = AccelerateInterpolator()


        animator.duration = 2000


        animator.start()

    }
}