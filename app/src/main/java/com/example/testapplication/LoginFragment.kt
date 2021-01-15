package com.example.testapplication

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.testapplication.databinding.LoginFragmentBinding
import com.example.testapplication.ui.Activity.HomeActivity
import com.example.testapplication.utils.AppConstant
import com.info.amazebeauty.sessionManager.SessionManager


class LoginFragment : Fragment() {


    companion object {
        const val TAG = "Home From Fragment"
        fun newInstance(): LoginFragment {
            val args = Bundle()
            val fragment = LoginFragment()
            fragment.arguments = args
            return fragment
        }
    }

    private var sharedPreferences: SharedPreferences? = null
    lateinit var binding: LoginFragmentBinding
    private lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sessionManager = SessionManager(requireContext())
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        sessionManager = SessionManager(requireContext())
 //       sharedPreferences = context?.getSharedPreferences(AppConstant.shared().PREFS_NAME, Context.MODE_PRIVATE)

        binding.loginBtn.setOnClickListener {

            validation()
        }

        binding.registerTxt.setOnClickListener {
            val intent = Intent(requireContext(), HomeActivity::class.java)
            intent.putExtra(AppConstant.shared().HOME_INTENT, AppConstant.shared().REGISTER)
            requireActivity().startActivity(intent)
            requireActivity().finish()
        }
    }

    private fun validation() {
        val email = binding.etemail.text.toString()
        val password = binding.etPassword.text.toString()

        if (email.trim().isNotEmpty() && password.trim().isNotEmpty()) {
            var uEmail: String? = null
            var uPassword: String? = null

            uEmail = sessionManager.getValueString(AppConstant.shared().PERSON_EMAIL)

            uPassword = sessionManager.getValueString(AppConstant.shared().PERSON_PASSWORD)



            if (binding.etemail.text.toString().equals(uEmail) && binding.etPassword.text.toString().equals(uPassword)) {
                sessionManager.createUserLoginSession(uEmail, uPassword)
                val intent = Intent(activity, MainActivity::class.java)
                requireActivity().startActivity(intent)
                requireActivity().finishAffinity()

            } else {
                Toast.makeText(
                    requireContext(), "Username/Password is incorrect", Toast.LENGTH_LONG).show()

            }
        } else {
            Toast.makeText(
                requireContext(), "Please enter username and password", Toast.LENGTH_LONG).show()

        }

    }
}
