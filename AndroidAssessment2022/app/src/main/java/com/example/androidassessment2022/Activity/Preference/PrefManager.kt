package com.example.androidassessment2022.Activity.Preference

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.res.TypedArrayUtils.getBoolean
import java.lang.Boolean.getBoolean
import java.lang.reflect.Array.getBoolean

class PrefManager(var context: Context) {

    private val PREF_NAME = "user-record"
    private val KEY_FIRST_NAME = "firstName"
    private val KEY_LAST_NAME = "lastName"
    private val KEY_EMAIL = "email"
    private val KEY_PASSWORD = "password"
    private val KEY_CONFIRM_PASSWORD = "confirmPassword"
    private val IS_LOGIN = "isLogin"

    private var sharedPreferences = context.getSharedPreferences(PREF_NAME , Context.MODE_PRIVATE)
    private var editor = sharedPreferences.edit()


    fun saveUserDetail(firstName : String , lastName : String , email : String , password : String , confirmPassword : String){

        editor.putString(KEY_FIRST_NAME , firstName)
        editor.putString(KEY_LAST_NAME , lastName)
        editor.putString(KEY_EMAIL , email)
        editor.putString(KEY_PASSWORD , password)
        editor.putString(KEY_CONFIRM_PASSWORD, confirmPassword)
    }
    fun saveLoginDetail(email: String , password: String){
        editor.putString(KEY_EMAIL , email)
        editor.putString(KEY_PASSWORD , password)
        editor.commit()
    }

    fun getLoginEmail():String{
        return sharedPreferences.getString(KEY_EMAIL,"")!!

    }

    fun getPass():String{
        return sharedPreferences.getString(KEY_PASSWORD,"")!!
    }


   fun getLoginStatus(): Boolean{
      return sharedPreferences.getBoolean(IS_LOGIN , false)
   }

    fun setLoginStatus(status : Boolean){

        editor.putBoolean(IS_LOGIN , status)
        editor.commit()

    }

    fun logOut(){
        editor.clear()
        editor.commit()
    }
}