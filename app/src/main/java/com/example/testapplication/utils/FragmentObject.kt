package com.example.testapplication.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.testapplication.LoginFragment
import com.example.testapplication.RegisterFragment
import com.example.testapplication.ui.home.HomeFragment

object FragmentObject {

    fun setCurrentFragment(
        pContext: FragmentActivity,
        pContainerId: Int,
        pFragment: Fragment,
        pTag: String
    ) {
        val fragmentManager = pContext.supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        if (isReplaceFragment(pFragment)) {
            fragmentTransaction.replace(pContainerId, pFragment, pTag)
        } else {
            fragmentTransaction.add(pContainerId, pFragment, pTag)
            fragmentTransaction.addToBackStack(null)
        }

        fragmentTransaction.commit()

    }

    fun checkFragmentInstance(context: FragmentActivity, mFragment: Fragment?) {

        if (isReplaceFragment(mFragment)) {
            context.finish()
        } else {
            context.supportFragmentManager.popBackStack()
        }
    }

    private fun isReplaceFragment(mFragment: Fragment?): Boolean {
        return mFragment is HomeFragment
                || mFragment is LoginFragment
                || mFragment is RegisterFragment


    }
}