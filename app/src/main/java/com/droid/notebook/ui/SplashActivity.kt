package com.droid.notebook.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.droid.notebook.R
import com.droid.notebook.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    private val bounceAnimation: Animation
        get() = AnimationUtils.loadAnimation(this, R.anim.anim_bounce)

    private val SPLASH_TIME_OUT: Long = 1500

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val activitySplashBinding: ActivitySplashBinding = DataBindingUtil.setContentView(this, R.layout.activity_splash)
        activitySplashBinding.splashLogoImage.startAnimation(bounceAnimation)
        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, SPLASH_TIME_OUT)
    }
}