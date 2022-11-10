package com.example.socialmediaintegration

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.facebook.AccessToken
import com.facebook.GraphRequest
import com.facebook.GraphResponse
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import org.json.JSONObject


class HomeActivity : AppCompatActivity() {



    val tvResult : TextView
    get() = findViewById(R.id.tv_result)

    lateinit var gso : GoogleSignInOptions
    lateinit var googleSignInClient: GoogleSignInClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this, gso)

        val acct = GoogleSignIn.getLastSignedInAccount(this)
        if (acct != null) {
            val personName = acct.displayName
            val personGivenName = acct.givenName
            val personFamilyName = acct.familyName
            val personEmail = acct.email
            val personId = acct.id
            val personPhoto: Uri? = acct.photoUrl

            tvResult.text = """
                
                $personName
                $personGivenName
                $personFamilyName
                $personEmail
                $personId
                $personPhoto
                
            """.trimIndent()
        }

        // facebook
        var accessToken =  AccessToken.getCurrentAccessToken()

        accessToken?.let {
           val request = GraphRequest.newMeRequest(it){
               jsonObject , response ->
               print(jsonObject)
               Log.d("Tag" , "onCompleted: $jsonObject")

               var name = jsonObject?.getString("name")
               var image = jsonObject?.getJSONObject("picture")?.getJSONObject("data")?.getJSONObject("url")

           }
            val parameters = Bundle()
            parameters.putString("fields", "id,name,link , picture.type(large) , email , birthday")
            request.parameters = parameters
            request.executeAsync()
        }
        findViewById<Button>(R.id.btn_logout).setOnClickListener {

            googleSignInClient.signOut().addOnCompleteListener {
                if (it.isSuccessful){
                    Toast.makeText(applicationContext, "Logout Successful", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(applicationContext , MainActivity::class.java))
                    finishAffinity()
                }
            }

        }
    }
}