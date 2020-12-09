package com.droid.notebook.ui.activities

import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.droid.notebook.R
import com.droid.notebook.databinding.ActivitySplashBinding
import com.droid.notebook.utils.constants.Constants
import com.droid.notebook.utils.navigator.AppNavigator
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {

    @Inject
    lateinit var navigator: AppNavigator

    private val bounceAnimation: Animation
        get() = AnimationUtils.loadAnimation(this, R.anim.anim_bounce)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val activitySplashBinding: ActivitySplashBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_splash)
        activitySplashBinding.splashLogoImage.startAnimation(bounceAnimation)

        Handler().postDelayed({
            navigator.navigateToNotebooksActivity()
            finish()
        }, Constants.splashTimeOut)
    }
}