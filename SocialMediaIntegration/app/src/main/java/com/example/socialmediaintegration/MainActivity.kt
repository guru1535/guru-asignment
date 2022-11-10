package com.example.socialmediaintegration

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.facebook.AccessToken
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import java.util.*


class MainActivity : AppCompatActivity() {

    lateinit var gso : GoogleSignInOptions
    lateinit var googleSignInClient: GoogleSignInClient
    private var RC_SIGN_IN = 100

    private lateinit var callbackManager : CallbackManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        callbackManager = CallbackManager.Factory.create()

        LoginManager.getInstance().registerCallback(callbackManager , object : FacebookCallback<LoginResult>  {
            override fun onCancel() {

            }

            override fun onError(error: FacebookException) {

            }

            override fun onSuccess(result: LoginResult) {

                result?.let {
                    navigateToHome(null)
                }

            }

        })
        findViewById<Button>(R.id.btn_facebook).setOnClickListener {


            LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("public_profile"))
        }


        gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken("90633398255-c6p9jcpi27um5fps2h04s26md1t042sd.apps.googleusercontent.com")
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this, gso)

        findViewById<Button>(R.id.btn_google).setOnClickListener {
            signIn()

        }

    }

    private fun signIn() {
        val signInIntent: Intent = googleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        callbackManager.onActivityResult(requestCode, resultCode, data)
        super.onActivityResult(requestCode, resultCode, data)



        if (requestCode == RC_SIGN_IN && resultCode == RESULT_OK){

            val task: Task<GoogleSignInAccount> =
                GoogleSignIn.getSignedInAccountFromIntent(data)
            handleSignInResult(task)

        }
    }

    private fun handleSignInResult(task: Task<GoogleSignInAccount>) {

        try {
            val account: GoogleSignInAccount = task.getResult(ApiException::class.java)

            // Signed in successfully, show authenticated UI.
            navigateToHome(account)
        } catch (e: ApiException) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
           // updateUI(null)
        }

    }

    private fun navigateToHome(account: GoogleSignInAccount?) {

        account?.let {
            Toast.makeText(applicationContext, "Welcome ${account.displayName}", Toast.LENGTH_SHORT).show()
        }



        var intent = Intent(applicationContext , HomeActivity::class.java)
        startActivity(intent)

    }

    override fun onResume() {
        super.onResume()

        val account = GoogleSignIn.getLastSignedInAccount(this)
        val accessToken = AccessToken.getCurrentAccessToken()
        val isLoggedIn = accessToken != null && !accessToken.isExpired


        if (account !=null || isLoggedIn ){
            navigateToHome(account)
        }


    }
}