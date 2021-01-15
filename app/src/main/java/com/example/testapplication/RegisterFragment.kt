package com.example.testapplication

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.testapplication.databinding.RegistrationFragmentBinding
import com.example.testapplication.ui.Activity.HomeActivity
import com.example.testapplication.utils.AppConstant
import com.info.amazebeauty.sessionManager.SessionManager
import com.info.amazebeauty.utils.AppUtils


class RegisterFragment : Fragment() {


    companion object {
        const val TAG = "Home From Fragment"
        fun newInstance(): RegisterFragment {
            val args = Bundle()
            val fragment = RegisterFragment()
            fragment.arguments = args
            return fragment
        }

    }

    lateinit var binding: RegistrationFragmentBinding
    private lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sessionManager = SessionManager(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_register, container, false)


        return binding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.isLoginTxt.setOnClickListener {
            val intent = Intent(requireContext(), HomeActivity::class.java)
            intent.putExtra(AppConstant.shared().HOME_INTENT, AppConstant.shared().ISLOGIN)
            requireActivity().startActivity(intent)
            requireActivity().finish()
        }

        binding.registerBtn.setOnClickListener {
            validation()
        }
    }

    private fun validation() {
        val firstName = binding.etFirstName.text.toString()
        val lastName = binding.etFirstName.text.toString()
        val email = binding.etEmail.text.toString()
        val password = binding.etPassword.text.toString()
        val confirmPwd = binding.etConfirmPwd.text.toString()

        sessionManager.save(AppConstant.shared().FIRST_NAME, firstName)
        sessionManager.save(AppConstant.shared().LAST_NAME, lastName)
        sessionManager.save(AppConstant.shared().PERSON_EMAIL, email)
        sessionManager.save(AppConstant.shared().PERSON_PASSWORD, confirmPwd)
        sessionManager.save(AppConstant.shared().IS_REGISTER,true)

        val intent = Intent(requireContext(), HomeActivity::class.java)
        intent.putExtra(AppConstant.shared().HOME_INTENT, AppConstant.shared().ISLOGIN)
        requireActivity().startActivity(intent)
        requireActivity().finish()


        when {
            firstName.isEmpty() -> {
                val msg = getString(R.string.enter_first_name)
                AppUtils.showWarningToast(requireContext(), msg)
            }

            lastName.isEmpty() -> {
                val msg = getString(R.string.enter_last_name)
                AppUtils.showWarningToast(requireContext(), msg)
            }

            email.isEmpty() -> {
                val msg = getString(R.string.enter_email)
                AppUtils.showWarningToast(requireContext(), msg)
            }

            password.isEmpty() -> {
                val msg = getString(R.string.enter_password)
                AppUtils.showWarningToast(requireContext(), msg)
            }

            confirmPwd.isEmpty() -> {
                val msg = getString(R.string.enter_confirm_password)
                AppUtils.showWarningToast(requireContext(), msg)
            }
        }
    }
}