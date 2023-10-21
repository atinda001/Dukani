package com.example.myshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var mAuth: FirebaseAuth
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

       mAuth = FirebaseAuth.getInstance()
        val user = mAuth.currentUser

       /* if user is not authenticated, send him to SignInActivity to authenticate first
       else send him to dashBoardActivity
        */
        Handler().postDelayed({
            if(user != null){
                val dashboardIntent = Intent(this, DashboardActivity::class.java)
                startActivity(dashboardIntent)
            }
            else{
                val signInIntent = Intent(this, signInActivity::class.java)
                startActivity(signInIntent)
            }
        }, 2000)


    }
}
