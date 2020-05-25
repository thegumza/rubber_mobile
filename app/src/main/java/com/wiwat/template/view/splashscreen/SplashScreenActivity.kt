package com.wiwat.template.view.splashscreen

import android.content.Intent
import android.os.Bundle
import com.wiwat.template.R
import com.wiwat.template.databinding.ActivityMainBinding
import com.wiwat.template.view.base.BindingActivity
import com.wiwat.template.view.main.MainActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenActivity : BindingActivity<ActivityMainBinding>() {
    override fun getLayoutResId(): Int {
        return R.layout.activity_splash_screen
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        GlobalScope.launch {
            delay(1000)
            startActivity(
                Intent(
                    this@SplashScreenActivity,
                    MainActivity::class.java
                ).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                    .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            )
        }
    }
}
