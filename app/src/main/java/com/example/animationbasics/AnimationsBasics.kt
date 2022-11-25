package com.example.animationbasics

import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.ToggleButton

class AnimationsBasics : AppCompatActivity() {

    lateinit var image: ImageView
    lateinit var togBtn: ToggleButton
    lateinit var anim: ObjectAnimator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        image = findViewById(R.id.image)
        togBtn = findViewById(R.id.toggleBtn)

        anim = ObjectAnimator.ofFloat(image, "rotation", 0f, 360f);
        anim.setDuration(1000);
        anim.setRepeatCount(1000);
        anim.setRepeatMode(ObjectAnimator.RESTART);
    }
}