package com.example.tugas2pm

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.view.animation.AnimationUtils
import android.content.Intent




class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val welcomeText = findViewById<TextView>(R.id.welcomeText)
        val fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        welcomeText.startAnimation(fadeIn)

        val forgotPasswordLink: TextView = findViewById(R.id.textView4)

        // Menangani klik pada link Forgot Password
        forgotPasswordLink.setOnClickListener {
            // Arahkan ke halaman reset password
            val intent = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(intent)
        }

        val registrationLink: TextView = findViewById(R.id.textView7)

        registrationLink.setOnClickListener{
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}