package com.example.testapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.testapplication.ui.Activity.HomeActivity
import com.example.testapplication.utils.AppConstant
import com.info.amazebeauty.utils.AppUtils

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        supportActionBar?.hide()

        if (AppUtils.getPrefBoolean(AppConstant.shared().USER_IS_LOGIN, this)) {
            Handler(Looper.getMainLooper()).postDelayed({
                startActivity(Intent(this, MainActivity::class.java))
                this.finish()
            }, 2000)
        } else {
            Handler(Looper.getMainLooper()).postDelayed({
                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra(AppConstant.shared().HOME_INTENT, AppConstant.shared().ISLOGIN)
                this.startActivity(intent)
                finish()
            }, 2000)
        }
    }
}