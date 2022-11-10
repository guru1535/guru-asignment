package com.example.kevalproject.Preference

import android.content.Context

class PrefManager(var context: Context) {

    private val PREF_NAME = "user-record"
    private val KEY_EMAIL = "email"
    private val KEY_PASSWORD = "password"
    private val IS_LOGIN = "isLogin"


    private var sharedPreferences = context.getSharedPreferences(PREF_NAME , Context.MODE_PRIVATE)
    private var editor = sharedPreferences.edit()

    fun saveUserDetail(email:String , password : String){

        editor.putString(KEY_EMAIL , email)
        editor.putString(KEY_PASSWORD , password)
    }
    fun setLoginStatus(status : Boolean){
        editor.putBoolean(IS_LOGIN , status)
        editor.commit()
    }

    fun getLoginStatus():Boolean{
        return sharedPreferences.getBoolean(IS_LOGIN , false)
    }
    fun logout(){
        editor.clear()
        editor.commit()
    }
}