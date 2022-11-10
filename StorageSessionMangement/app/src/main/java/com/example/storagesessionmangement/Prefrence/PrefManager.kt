package com.example.storagesessionmangement.Prefrence

import android.content.Context

class PrefManager(context: Context) {

    private val PREF_NAME = "user-record"
    private val KEY_FIRSTNAME = "firstName"
    private val KEY_LASTNAME = "lastName"
    private val KEY_EMAIL = "email"
    private val KEY_CONTACT = "contact"
    private val KEY_PASSWORD = "password"
    private val KEY_CONFIRMPASSWORD = "confirmPassword"
    private val IS_LOGIN = "isLogin"

    private var sharedPreferences = context.getSharedPreferences(PREF_NAME , Context.MODE_PRIVATE)
    private var editor = sharedPreferences.edit()


    fun saveUserDetail(firstName : String , lastName :String , email :String , contact :String , password:String , confirmPassword : String){

        editor.putString(KEY_FIRSTNAME , firstName)
        editor.putString(KEY_LASTNAME , lastName)
        editor.putString(KEY_EMAIL , email)
        editor.putString(KEY_CONTACT , contact)
        editor.putString(KEY_PASSWORD , password)
        editor.putString(KEY_CONFIRMPASSWORD , confirmPassword)


    }

    fun getUserDetail():Array<String?>{

        var firstName = sharedPreferences.getString(KEY_FIRSTNAME , "")
        var lastName = sharedPreferences.getString(KEY_LASTNAME , "")
        var email = sharedPreferences.getString(KEY_EMAIL , "")
        var contact = sharedPreferences.getString(KEY_CONTACT , "")

        return arrayOf(firstName , lastName , email , contact)

    }

    fun setLoginStatus(status: Boolean){
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