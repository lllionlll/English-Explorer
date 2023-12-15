package io.graduation.haui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_view)
        Handler(Looper.getMainLooper()).postDelayed({
            finishAndRemoveTask()
            startActivity(Intent(this, MainActivity::class.java))

        },2000)
    }
}