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
        // 뷰에 이미지 설정

        val parentView =
            findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.parentLayout)
        // 부모 레이아웃을 찾아옵니다. 여기서는 ConstraintLayout을 사용했습니다.

        parentView.addView(imageView)
        // 부모 레이아웃에 뷰 추가
        val initialTranslationY = 1500f
        val finalTranslationY = parentView.height.toFloat() - imageView.height

        val animator =
            ObjectAnimator.ofFloat(
                imageView,
                "translationY",
                1600f,
                initialTranslationY,
                finalTranslationY
            )
        // ObjectAnimator를 사용하여 translationY 속성을 애니메이션화합니다.
        // 뷰의 초기 위치는 부모 레이아웃의 아래쪽으로 설정되고, 애니메이션이 진행됨에 따라 위쪽으로 이동합니다.
        imageView.scaleType = ImageView.ScaleType.CENTER

        animator.interpolator = AccelerateInterpolator()
        // 애니메이션의 보간자(interpolator)를 설정합니다.
        // 여기서는 가속 보간자(AccelerateInterpolator)를 사용하여 애니메이션의 시작 부분을 느리게 시작하고 점점 가속화합니다.

        animator.duration = 1000
        // 애니메이션의 지속 시간을 설정합니다. 여기서는 1000ms(1초)로 설정했습니다.

        animator.start()
        // 애니메이션 시작
    }
}