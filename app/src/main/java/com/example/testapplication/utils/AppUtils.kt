package com.info.amazebeauty.utils

import android.app.Activity
import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceManager
import com.example.testapplication.MainActivity
import com.example.testapplication.R
import com.example.testapplication.ui.Activity.HomeActivity
import com.example.testapplication.utils.AppConstant
import com.sdsmdg.tastytoast.TastyToast
import java.text.SimpleDateFormat
import java.util.*

object AppUtils {


    fun showWarningToast(context: Context, message: String?) {
        if (message.isNullOrEmpty()) {
            val msg = context.getString(R.string.something_went_wrong)
            TastyToast.makeText(context, msg, TastyToast.LENGTH_LONG, TastyToast.WARNING)
        } else {
            TastyToast.makeText(context, message, TastyToast.LENGTH_LONG, TastyToast.WARNING)
        }
    }

    fun getPrefBoolean(key: String, context: Context): Boolean {
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        return preferences.getBoolean(key, false)
    }







}
