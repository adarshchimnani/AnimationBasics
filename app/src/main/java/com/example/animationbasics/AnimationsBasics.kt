package com.example.animationbasics

import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import android.widget.ToggleButton
import java.lang.Exception

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

    fun spin(view: View) {
        //1 - runOnUiThread Approach
        val thread = Thread(Runnable {
            runOnUiThread {
                try {
                    if (anim.isPaused) {
                        anim.resume()
                        Toast.makeText(this, "Resume", Toast.LENGTH_LONG).show()

                    } else if (togBtn.isChecked) {
                        anim.start()
                        Toast.makeText(this, "Start", Toast.LENGTH_LONG).show()
                    } else {
                        anim.pause()
                        Toast.makeText(this, "Pause", Toast.LENGTH_LONG).show()
                    }
                } catch (e: Exception) {
                    Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()

                }
            }
        })

        thread.start()
    }
}