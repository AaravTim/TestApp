/*
 * *
 *  * Created by Raj shah on 12/3/20 10:54 AM
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 12/3/20 10:54 AM
 *
 */

package com.example.testapplication.utils

class AppConstant {

    companion object {
        private var instance: AppConstant? = null
        fun shared(): AppConstant {

            if (instance == null) {
                instance = AppConstant()
            }
            return instance!!
        }
    }


    val PREFS_NAME = "kotlincodes"
    val USER_IS_LOGIN = "User Login"
    val FIRST_NAME = "First Name"
    val LAST_NAME = "Last Name"
    val PERSON_EMAIL = "Person Email"
    val PERSON_PASSWORD = "Person PASSWORD"
    val ISLOGIN = "Is Login"
    var HOME_INTENT = "home_intent"
    var SECRET_KEY = "secret_key"
    val REGISTER = "Register"
    val IS_REGISTER = "Is Register"
    val FIRST_TIME_USER = " User First Time"


}