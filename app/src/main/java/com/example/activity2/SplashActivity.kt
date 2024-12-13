package com.example.activity2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Set an OnClickListener on the splash screen to proceed to MainActivity
        findViewById<View>(R.id.splashText).setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        val planeImage: ImageView = findViewById(R.id.planeImage)
        val splashText: TextView = findViewById(R.id.splashText)
        val planeAnimation = AnimationUtils.loadAnimation(this, R.anim.plane_move)
        val textAnimation = AnimationUtils.loadAnimation(this, R.anim.text_slide)
        planeImage.startAnimation(planeAnimation)
        splashText.startAnimation(textAnimation) // Set a listener to launch MainActivity after the animation ends
        planeAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {}
            override fun onAnimationEnd(animation: Animation?) {
                startActivity(
                    Intent(
                        this@SplashActivity,
                        MainActivity::class.java
                    )
                )
                finish()
            }

            override fun onAnimationRepeat(animation: Animation?) {}
        })

    }
}
