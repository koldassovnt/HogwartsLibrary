package com.example.hogwartslibrary.ui.scenes.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hogwartslibrary.R
import com.example.hogwartslibrary.helpers.Keys
import com.example.hogwartslibrary.ui.scenes.hat.HatActivity
import com.example.hogwartslibrary.ui.scenes.main.MainActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val username = getSharedPreferences(getString(R.string.app_name), 0)
            .getString(Keys.Username.value, "") ?: ""

        if (username.isEmpty()) {
            startActivity(Intent(applicationContext, HatActivity::class.java))
        } else {
            startActivity(Intent(applicationContext, MainActivity::class.java))
        }
    }
}
