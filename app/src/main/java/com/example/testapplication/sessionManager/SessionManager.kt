package com.info.amazebeauty.sessionManager

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import com.example.testapplication.utils.AppConstant


class SessionManager(context: Context) {
    private val sharedPref: SharedPreferences = context.getSharedPreferences(AppConstant.shared().PREFS_NAME, Context.MODE_PRIVATE
    )

    // StringValue
    fun save(key: String, value: String) {
        val editor: SharedPreferences.Editor = sharedPref.edit()
        editor.putString(key, value)
        editor.apply()
    }


    // BooleanValue
    fun save(KEY_NAME: String, status: Boolean) {
        val editor: SharedPreferences.Editor = sharedPref.edit()
        editor.putBoolean(KEY_NAME, status)
        editor.apply()
    }


    fun getValueString(key: String): String? {
        return sharedPref.getString(key, null)
    }


    fun getValueBoolean(KEY_NAME: String, defaultValue: Boolean): Boolean {
        return sharedPref.getBoolean(KEY_NAME, defaultValue)

    }


    fun removeValue(KEY_NAME: String) {
        val editor: SharedPreferences.Editor = sharedPref.edit()
        editor.remove(KEY_NAME)
        editor.apply()
    }

    fun clearSharedPreference() {
        val editor: SharedPreferences.Editor = sharedPref.edit()
        // sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
        editor.clear()
        editor.apply()
    }

    fun createUserLoginSession(uEmail: String?, uPassword: String?) {
        val editor: SharedPreferences.Editor = sharedPref.edit()
        editor.putBoolean(AppConstant.shared().USER_IS_LOGIN, true)
        editor.putString(AppConstant.shared().PERSON_EMAIL, uEmail)
        editor.putString(AppConstant.shared().PERSON_PASSWORD, uPassword)
        editor.apply()
    }

}