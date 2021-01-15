package com.example.testapplication.ui.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.testapplication.utils.AppConstant.Companion.shared
import com.example.testapplication.utils.FragmentObject
import com.example.testapplication.LoginFragment
import com.example.testapplication.R
import com.example.testapplication.RegisterFragment
import com.example.testapplication.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    lateinit var binding: ActivityHomeBinding
    private var homeIntent: String? = null
    private var secretKey: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        val intent = intent
        if (intent.extras != null) {
            homeIntent = intent.extras!!.getString(shared().HOME_INTENT)
            secretKey = intent.extras!!.getString(shared().SECRET_KEY)

        }

        setFragment()
    }

    private fun setFragment() {
        when (homeIntent) {
            shared().ISLOGIN -> {
                FragmentObject.setCurrentFragment(
                    this, R.id.fragment,
                    LoginFragment.newInstance(), LoginFragment.TAG
                )
            }


            shared().REGISTER -> {
                FragmentObject.setCurrentFragment(
                    this, R.id.fragment,
                    RegisterFragment.newInstance(), RegisterFragment.TAG
                )
            }
        }
    }
}